import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
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

import org.w3c.dom.Document;

import de.ffn.otrs.client.JaxbContext;
import de.ffn.otrs.client.OTRSException;
import de.ffn.otrs.client.OTRSTicketConnector;
import de.ffn.otrs.client.OTRSTicketConnectorImpl;
import de.ffn.otrs.client.OtrsConnector;
import de.ffn.otrs.client.TicketState;
import de.ffn.otrs.client.objects.Article;
import de.ffn.otrs.client.objects.ArticleType;
import de.ffn.otrs.client.objects.DynamicField;
import de.ffn.otrs.client.objects.SessionCreate;
import de.ffn.otrs.client.objects.Ticket;
import de.ffn.otrs.client.objects.TicketCreate;
import de.ffn.otrs.client.objects.TicketCreateResponse;
import de.ffn.otrs.client.objects.TicketGet;
import de.ffn.otrs.client.objects.TicketSearch;
import de.ffn.otrs.client.objects.TicketSearchResponse;
import de.ffn.otrs.client.objects.TicketUpdate;
import de.ffn.otrs.client.objects.TicketUpdateResponse;


public class Main {

	private static JaxbContext jctx;
	private static OTRSTicketConnectorImpl octc;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		octc = new OTRSTicketConnectorImpl( "skleese", "", "http://portal.ff-n.org/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnector/"); 
		
		example_CreateTicket();
		
		example_SearchTickets_withDynamicFields();
		
//		example_SearchTickets();
		
//		example_CreateTicket();
		
		example_UpdateTicket();
		
		
		if(0==1)
			example_ReadTicket(null);
		
		if(0==1)
			example_SearchTickets();
		
		if(0==1)
			example_ReadTicket(null);
//		
//		if(0==1)
//			oldStuff();
		
	}


	private static void example_SearchTickets_withDynamicFields() {
		TicketSearch search = new TicketSearch();
//		search.setTitle("*OTRS*");
//		search.setTicketNumber("2014010990000019");
		List<String> states = new ArrayList<String>();
		states.add(TicketState.SUCCESSFULLY_CLOSED.getLabel());
//		states.add("closed");
//		search.setStates(states);
		
		List<DynamicField> dfList = new ArrayList<DynamicField>();
		DynamicField df1 = new DynamicField();
		df1.setName("Fahrzeug");
		dfList.add(df1);
		search.setDynamicField(dfList);
		try {
			List<String> resultID = octc.searchTickets(search);
			
			List<Ticket> t = octc.getTicket(resultID, true, true, false);
			
			
			System.out.println();
			
		} catch (OTRSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private static void example_UpdateTicket() {
		
		TicketCreateResponse newTicket = example_CreateTicket();
		
		Ticket ticket = example_ReadTicket(newTicket.getTicketID());
		
		
		ticket.setState(TicketState.SUCCESSFULLY_CLOSED.getLabel());
		
		Article a = new Article();
		a.setSubject("test2");
		a.setBody("test body2");
		a.setContentType("text/plain; charset=utf8");
		
		
		try {
			TicketUpdateResponse updatedTicket = octc.updateTicket(ticket, a);
			
			System.out.println();
			
		} catch (OTRSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private static TicketCreateResponse example_CreateTicket() {
	
		Ticket t = new Ticket();
		t.setCustomerUser("shawn.kleese@ituv-software.de");
		t.setCustomerID("shawn.kleese@ituv-software.de");
		t.setCustomerUserID("shawn.kleese@ituv-software.de");
		t.setTitle("TEST Title 2 // mit DynFields");
		t.setQueue("Amt37");
		t.setState("new");
		t.setType("Unclassified");
		t.setPriority("3 normal");
		
		List<DynamicField> dfList = new ArrayList<DynamicField>();
		DynamicField df1 = new DynamicField();
		df1.setName("Fahrzeug");
		df1.setValue(new ArrayList<String>());
		df1.getValue().add("90321");
		dfList.add(df1);
		
		
		Article a = new Article();
		a.setArticleType(ArticleType.EMAIL_EXTERNAL.getLabel());
		a.setSubject("Mit DynFields");
		a.setBody("test body2 Mit DynFields");
		a.setContentType("text/plain; charset=utf8");
		a.setNoAgentNotify(1);
		try {
			TicketCreateResponse ticket = octc.createTicket(t, a, dfList);
			return ticket;
		} catch (OTRSException e) {
			e.printStackTrace();
			throw new RuntimeException("Keine Ticket erstellet...");
			
		}
		
	}


	private static void example_SearchTickets() {
		
		TicketSearch search = new TicketSearch();
//		search.setTitle("*OTRS*");
		search.setTicketNumber("2014010990000019");
		List<String> states = new ArrayList<String>();
//		states.add(TicketState.SUCCESSFULLY_CLOSED.getLabel());
//		states.add("closed");
//		search.setStates(states);
		
		try {
			List<String> resultID = octc.searchTickets(search);
			
			Ticket t = octc.getTicket(resultID.get(0), true, true, false);
			
			
			System.out.println();
			
		} catch (OTRSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private static Ticket example_ReadTicket(String ticketId) {
		
		try {
			Ticket ticket = octc.getTicket(ticketId, true, true, false);
			return ticket;
		} catch (OTRSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}


//	private static void oldStuff() {
//		SessionCreate sess = new SessionCreate();
////		sess.setUserLogin("skleese");
////		sess.setPassword("bravo2");
//		
//		TicketSearch ts = new TicketSearch();
//		ts.setUserLogin("skleese");
//		ts.setPassword("bravo2");
//		ts.setTitle("*");
//		
//		TicketGet tg = new TicketGet();
//		tg.setUserLogin("skleese");
//		tg.setPassword("bravo2");
//		tg.setTicketID("1");
//		
////		TicketCreate tc = new TicketCreate();
////		tc.s
//		
//		try {
//			jctx = JaxbContext.getInstance();
//			testxml();
//			
//		
//			try {//"http://portal.ff-n.org/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnector/"
//				OtrsConnector oc = new OtrsConnector("http://portal.ff-n.org/otrs/nph-genericinterface.pl/Webservice/GenericTicketConnector/", "skleese", "bravo2");
//				//<UserLogin>some user login</UserLogin><Password>some password</Password>
//				
//				StringWriter sw = new StringWriter();
//				
//				jctx.createMarshaller().marshal(tg, sw);
//				
//				String s = sw.toString();
//				
//				SOAPMessage msg = oc.dispatchCall(s, "TicketGet");
//				
//				SOAPPart msgBody = msg.getSOAPPart();
//				System.out.println();
//				SOAPBody body = msgBody.getEnvelope().getBody();
//				String text = parseSOAPBodyToString(body);
//				System.out.println(text);
//				
//				try {
//					Object o = jctx.createUnmarshaller().unmarshal(new StringReader(text));
//					System.out.println();
//				} catch(Exception e) {
//					e.printStackTrace();
//				}	
//				System.out.println(text);
//				
//				//<SessionCreate><UserLogin>?</UserLogin><CustomerUserLogin>?</CustomerUserLogin><Password>?</Password></SessionCreate>
//				//"<Ticket><Title>some title</Title><CustomerUser>some customer user login</CustomerUser><Queue>some queue</Queue><State>some state</State><Priority>some priority</Priority></Ticket><Article><Subject>some subject</Subject><Body>some body</Body><ContentType>text/plain; charset=utf8</ContentType></Article>"
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SOAPException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (JAXBException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
	
	
	private static void testxml() throws JAXBException {
		StringWriter sw = new StringWriter();
		
		TicketSearchResponse tsr = new TicketSearchResponse();
		List<String> ticketIDs = new ArrayList<String>();
		ticketIDs.add("1");
		ticketIDs.add("2");
		tsr.setTicketIDs(ticketIDs);
		
		
		jctx.createMarshaller().marshal(tsr, sw);
		
		String s = sw.toString();
		System.out.println(s);
		
		System.out.println();
	}


	public static String parseSOAPBodyToString(SOAPBody body){
	          String strBody=null;
	          try {
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



}
