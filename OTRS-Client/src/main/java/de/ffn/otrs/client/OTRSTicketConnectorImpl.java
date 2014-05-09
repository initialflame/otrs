package de.ffn.otrs.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import de.ffn.otrs.client.objects.Article;
import de.ffn.otrs.client.objects.DynamicField;
import de.ffn.otrs.client.objects.OTRSRequest;
import de.ffn.otrs.client.objects.OTRSResponse;
import de.ffn.otrs.client.objects.SessionCreate;
import de.ffn.otrs.client.objects.Ticket;
import de.ffn.otrs.client.objects.TicketCreate;
import de.ffn.otrs.client.objects.TicketCreateResponse;
import de.ffn.otrs.client.objects.TicketGetResponse;
import de.ffn.otrs.client.objects.TicketSearch;
import de.ffn.otrs.client.objects.TicketSearchResponse;
import de.ffn.otrs.client.objects.TicketUpdate;
import de.ffn.otrs.client.objects.TicketUpdateResponse;

public class OTRSTicketConnectorImpl implements OTRSTicketConnector {

	private static final String OTRS_METHOD_TICKET_GET = "TicketGet";
	private static final String OTRS_METHOD_TICKET_SEARCH = "TicketSearch";
	private static final String OTRS_METHOD_TICKET_CREATE = "TicketCreate";
	private static final String OTRS_METHOD_TICKET_UPDATE = "TicketUpdate";
	
	
	private static final String PREFIX_DYNAMICFIELD = "DynamicField_";
	private static final String FIELD_TICKET_ID = "TicketID";
	
	private OtrsConnector oc;
	private JaxbContext jCtx;
	
	private String userlogin;
	private String password;

	
	
	public OTRSTicketConnectorImpl(String user, String password, String otrsserviceUrl) {
		super();
		try {
			this.userlogin = user;
			this.password = password;
			this.oc = new OtrsConnector(otrsserviceUrl, user, password);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("URL is malformed "+otrsserviceUrl,e);
		}
		
		try {
			jCtx = JaxbContext.getInstance();
		} catch (JAXBException e) {
			throw new IllegalArgumentException("Fehler beim initialisieren des XML-Contextes ",e);
		}
	}

	@Override
	public List<Ticket> getTicket(List<String> ticketId, boolean readArticles, boolean readDynamicFields, boolean readAttachments) throws OTRSException {
		if(ticketId == null)
			throw new IllegalArgumentException("TicketId darf nicht null sein!");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("TicketID", ticketId);
		if(readArticles) params.put("AllArticles", "y");
		if(readDynamicFields) params.put("DynamicFields", "y");
		if(readAttachments) params.put("Attachments", "y");
		Object response = null;
		response = executeSoapCall(OTRS_METHOD_TICKET_GET, null, params, readDynamicFields, false);
		
		if(response != null && response instanceof TicketGetResponse) {
			TicketGetResponse tgr = (TicketGetResponse) response;
			return tgr.getTickets();
		}
		
		return null;
	}
	
	@Override
	public Ticket getTicket(String ticketId, boolean readArticles,
			boolean readDynamicFields, boolean readAttachments)
			throws OTRSException {
		
		List<String> ticketIds = new ArrayList<String>();
		ticketIds.add(ticketId);
		List<Ticket> tgr = getTicket(ticketIds, readArticles, readDynamicFields, readAttachments);
		
		if(tgr != null
				&& tgr.size() == 1)
			return tgr.get(0);
		
		return null;
	}

	private Object executeSoapCall(String method, Object object, Map<String, Object> params, boolean parseDynamicFields, boolean writeDynamicFields)
			throws OTRSException {
		Object response = null;
		try {
			String objectStr = jCtx.marshal(object);
			if(writeDynamicFields)
				objectStr = addDynamicFields(objectStr, object);
			SOAPMessage ticket = oc.dispatchCall(object, objectStr, method, params);
			response = extractResponse(ticket, parseDynamicFields);
			
			
		} catch (SOAPException e) {
			throw new OTRSException(e);
		} catch (IOException e) {
			throw new OTRSException(e);
		} catch (JAXBException e) {
			throw new OTRSException("Fehler beim parsen der XML-Daten",e);
		}
		return response;
	}


	private Object extractResponse(SOAPMessage msg, boolean parseDynamicFields) throws JAXBException, OTRSException {
		String s = parseSOAPBodyToString(msg, parseDynamicFields);
		
		Object obj = jCtx.createUnmarshaller().unmarshal(new StringReader(s));
		if(parseDynamicFields)
			extraxtDynamicFields(s, obj);
		
		if(obj instanceof OTRSResponse
				&& ((OTRSResponse)(obj)).getError() != null){
			throw new OTRSException("OTRS-Fehler od. Fehler in der Schnittstelle: "+((OTRSResponse)(obj)).getError().toString(), (OTRSResponse)obj);
		}
		
		return obj;
	}
	
	private String addDynamicFields(String objectStr, Object object) {
		if(objectStr == null)
			return null;
		
		if(!(object instanceof TicketCreate) && !(object instanceof TicketUpdate))
			throw new IllegalArgumentException("Dynamische Felder koennen nur an TicketCreate oder TiketUpdate hinzugefuegt werden!");
		
		 	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder;
			try {
				dBuilder = dbFactory.newDocumentBuilder();
			
		    	Document doc2 = dBuilder.parse(new ByteArrayInputStream(objectStr.getBytes("utf8")));
		     
		    	doc2.getDocumentElement().normalize();
		    	
		    	Node ticketCreateOrUpdateNode = doc2.getFirstChild();
		    	
		    	Ticket t = null;
		    	
		    	if(object instanceof TicketCreate){
		    		t = ((TicketCreate)object).getTicket();
		    	} else if(object instanceof TicketUpdate) {
		    		t = ((TicketUpdate)object).getTicket();
		    	} else {
		    		throw new IllegalArgumentException("Unbekannter Objekttyp: "+object.getClass().getName()); 
		    	}
		    	
		    	List<DynamicField> dFields = t.getDynamicFields();
		    	if (dFields == null || dFields.isEmpty())
		    		return objectStr;
		    	
		    	Node nodeTicket = getNode(ticketCreateOrUpdateNode.getChildNodes(), "Ticket");
		    	
		    	for (DynamicField dynamicField : dFields) {
		    		String value = null;
		    		if(!dynamicField.getValue().isEmpty())
		    			value = dynamicField.getValue().get(0);
		    		Node dynFieldNode = doc2.createElement(PREFIX_DYNAMICFIELD+dynamicField.getName());
		    		dynFieldNode.setTextContent(value);
		    		nodeTicket.appendChild(dynFieldNode);
				}
		    	
		    	DOMSource domSource = new DOMSource(doc2);
		        StringWriter writer = new StringWriter();
		        StreamResult result = new StreamResult(writer);
		        TransformerFactory tf = TransformerFactory.newInstance();
		        Transformer transformer = tf.newTransformer();
		        transformer.transform(domSource, result);

		        StringBuffer sb = writer.getBuffer(); 
		        String finalstring = sb.toString();
		        return finalstring;
		    	
		    	
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				return null;
			} catch (SAXException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			} catch (TransformerException e) {
				e.printStackTrace();
				return null;
			}  
	}

	/**
	 * Möglichkeit zum extrahieren der Dynamischen Felder
	 * @param obj 
	 */
	private void extraxtDynamicFields(String strBody, Object obj) {
		if(!(obj instanceof TicketGetResponse))
			return;
		
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		
	    	Document doc2 = dBuilder.parse(new ByteArrayInputStream(strBody.getBytes("utf8")));
	     
	    	//optional, but recommended
	    	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	    	doc2.getDocumentElement().normalize();
	    	
	    	Node ticketGetResponseNOde = doc2.getFirstChild();
	    	
	    	if(ticketGetResponseNOde != null) {
	    		
	    		NodeList childNOdes = ticketGetResponseNOde.getChildNodes();
	    		
	    		for (int i = 0; i < childNOdes.getLength(); i++) {
					Node subnode = childNOdes.item(i);
					if("Ticket".equals(subnode.getNodeName())) {
						
						NodeList ticketElements = subnode.getChildNodes();
						List<DynamicField> dfList = new ArrayList<DynamicField>();
						
						for (int j = 0; j < ticketElements.getLength(); j++) {
							Node ticketvars = ticketElements.item(j);
							
							if(ticketvars != null 
									&& ticketvars.getNodeName().startsWith(PREFIX_DYNAMICFIELD)){
								String nodename = ticketvars.getNodeName().substring(PREFIX_DYNAMICFIELD.length(), 
										ticketvars.getNodeName().length());
								DynamicField df = new DynamicField(nodename, ticketvars.getNodeValue());
								dfList.add(df);
								
								
							}
							
						}
						
						if(dfList != null && !dfList.isEmpty()) {
							String ticketID = getNodeValue(ticketElements, FIELD_TICKET_ID); 
							
							attachDynamicFields((TicketGetResponse) obj, ticketID, dfList);
							
						}
						
						
					}
					
					
				}
	    	}
	    	
	    	
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch ( IOException e) {
			e.printStackTrace();
		}
	}

	private void attachDynamicFields(Object obj, String ticketID, List<DynamicField> dfList) {
		if(!(obj instanceof TicketGetResponse)) {
			throw new IllegalArgumentException("Methode nicht implementiert fuer Klasse: "+obj.getClass().getName());
		}
		
		TicketGetResponse tgr = (TicketGetResponse) obj;
		List<Ticket> tickets = tgr.getTickets();
		
		if(tickets == null || ticketID == null) return;
		for (Ticket ticket : tickets) {
			if(ticket == null) continue;
			String id = ticket.getTicketID();
			if(ticketID.equals(id)) {
				ticket.addDynamicFields(dfList);
				break;
			}
		}		
		
		
	}

	@Override
	public TicketCreateResponse createTicket(Ticket ticket, Article article, List<DynamicField> dynamicFields) throws OTRSException {
		if(ticket == null)
			throw new IllegalArgumentException("Ticket darf nicht null sein!");
		if(article == null)
			throw new IllegalArgumentException("Article darf nicht null sein!");
		
		TicketCreate tc = new TicketCreate();
		addAuthenticationInformation(tc);
		tc.setTicket(ticket);
		tc.setArticle(article);
		tc.setDynamicFields(dynamicFields);
		
		Object response = executeSoapCall(OTRS_METHOD_TICKET_CREATE, tc, null, false, true);
		
		if(response != null && response instanceof TicketCreateResponse) {
			TicketCreateResponse tgr = (TicketCreateResponse) response;
			return tgr;
		}
		
		return null;
	}

	@Override
	public TicketUpdateResponse updateTicket(Ticket ticket, Article article) throws OTRSException {
		if(ticket == null)
			throw new IllegalArgumentException("Ticket darf nicht null sein!");
		if(article == null)
			throw new IllegalArgumentException("Article darf nicht null sein!");
		
		TicketUpdate tc = new TicketUpdate(ticket);
		addAuthenticationInformation(tc);
		tc.setTicket(ticket);
		tc.setArticle(article);
		
		Object response = executeSoapCall(OTRS_METHOD_TICKET_UPDATE, tc, null, false, true);
		
		if(response != null && response instanceof TicketUpdateResponse) {
			TicketUpdateResponse tgr = (TicketUpdateResponse) response;
			return tgr;
		}
		
		return null;
	}

	@Override
	public List<String> searchTickets(TicketSearch search) throws OTRSException {
		if(search == null)
			throw new IllegalArgumentException("TicketSearch darf nicht null sein!");
		
		Map<String, Object> params = new HashMap<String, Object>();
//		if(search.getTitle() != null)params.put("Title", search.getTitle());
//		if(search.getBody() != null)params.put("Body", search.getBody());
//		if(search.getTicketNumber() != null)params.put("TicketNumber", search.getTicketNumber());
//		if(search.getStates() != null)params.put("States", search.getStates());
//		if(search.getCreatedUserIDs() != null)params.put("CreatedUserIDs", search.getCreatedUserIDs());
//		if(search.getQueues() != null)params.put("Queues", search.getQueues());
//		if(search.getLimit() != null)params.put("Limit", search.getLimit());
//		if(search.getUseSubQueues() != null)params.put("UseSubQueues", search.getUseSubQueues());
		
		addAuthenticationInformation(search);
		
		Object response = executeSoapCall(OTRS_METHOD_TICKET_SEARCH, search, params, false, false);
		
		if(response != null && response instanceof TicketSearchResponse) {
			TicketSearchResponse tsr =  (TicketSearchResponse) response;
			return tsr.getTicketIDs();
		}
		
		return null;
	}

	private void addAuthenticationInformation(OTRSRequest req) {
		if(req == null) return;
		req.setUserLogin(userlogin);
		req.setPassword(password);
	}

	@Override
	public SessionCreate createSession(SessionCreate session) throws OTRSException {
		addAuthenticationInformation(session);
		return null;
	}
	
	
	public static String parseSOAPBodyToString(SOAPMessage msg, boolean parseDynamicFiels){
		String strBody=null;
		try {
			SOAPPart msgBody = msg.getSOAPPart();
			SOAPBody body = msgBody.getEnvelope().getBody();
			
	        
            Document doc = body.extractContentAsDocument();

            Source source = new DOMSource(doc);
            StringWriter stringWriter = new StringWriter();
            Result result = new StreamResult(stringWriter);
            TransformerFactory factory = TransformerFactory.newInstance();
	        Transformer transformer = factory.newTransformer();
	        transformer.transform(source, result);
	        strBody=stringWriter.getBuffer().toString();
	        
        } catch (SOAPException e) {
        } catch (TransformerConfigurationException e) {
        } catch (TransformerException e) {
        }
        
        return strBody;
   }

	private static String getNodeValue(NodeList cNodes, String string) {
		if(cNodes == null || string == null) return null;
		for (int i = 0; i < cNodes.getLength(); i++) {
			Node node = cNodes.item(i);
			if(string.equals(node.getNodeName())){
				return node.getTextContent();
			}
		}
		
		return null;
	}
	
	private static Node getNode(NodeList cNodes, String string) {
		if(cNodes == null || string == null) return null;
		for (int i = 0; i < cNodes.getLength(); i++) {
			Node node = cNodes.item(i);
			if(string.equals(node.getNodeName())){
				return node;
			}
		}
		
		return null;
	}

}
