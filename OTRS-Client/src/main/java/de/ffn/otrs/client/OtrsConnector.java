package de.ffn.otrs.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class OtrsConnector {

	private final URL otrsUrl;
	private final String otrsUser;
	private final String otrsPass;

	private final Logger log = LoggerFactory.getLogger(getClass());

	protected OtrsConnector(String otrsUrl, String otrsUser, String otrsPass)
			throws MalformedURLException {
		super();
		this.otrsUrl = new URL(otrsUrl);
		this.otrsUser = otrsUser;
		this.otrsPass = otrsPass;
	}

	public SOAPMessage dispatchCall(Object obj, String stringObject, String method)
			throws SOAPException, IOException {
		return this.dispatchCall(obj, stringObject, method, new HashMap<String, Object>());
	}

	private SOAPMessage buildRPCMessage(String operation, boolean addOperationXMLElement) throws SOAPException {
		// Create message
		MessageFactory mf = MessageFactory.newInstance();
		SOAPMessage msg = mf.createMessage();
		// Object for message parts
		SOAPPart sp = msg.getSOAPPart();
		SOAPEnvelope env = sp.getEnvelope();
		env.removeNamespaceDeclaration("SOAP-ENV");  
		env.setPrefix("soap"); 
//		env.addNamespaceDeclaration("ns", "http://www.otrs.org/TicketConnector/");
//		env.setElementQName(new QName("soap", "Envelope"));
		
		env.addNamespaceDeclaration("xsd", XMLConstants.W3C_XML_SCHEMA_NS_URI);
		env.addNamespaceDeclaration("xsi", XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
		env.addNamespaceDeclaration("soapenc", SOAPConstants.URI_NS_SOAP_ENCODING);
//		env.addNamespaceDeclaration("soap", SOAPConstants.URI_NS_SOAP_ENVELOPE);
//		env.addNamespaceDeclaration("env", SOAPConstants.URI_NS_SOAP_ENVELOPE);
		
		env.setEncodingStyle(SOAPConstants.URI_NS_SOAP_ENCODING);

		env.getHeader().recycleNode();
		
//		SOAPHeader head = env.getHeader();
//		head.removeNamespaceDeclaration("SOAP-ENV");  
//		head.setPrefix("soap"); 
		
		SOAPBody body = env.getBody();
		body.removeNamespaceDeclaration("SOAP-ENV");  
		body.setPrefix("soap"); 
		//"/Core"
		if(addOperationXMLElement){
			SOAPBodyElement dispatch = body.addBodyElement(new QName("http://www.otrs.org/TicketConnector/",
					operation)); //"Dispatch" 
			dispatch.addChildElement("UserLogin").addTextNode(otrsUser)
					.setAttribute("xsi:type", "xsd:string");
			dispatch.addChildElement("Password").addTextNode(otrsPass)
					.setAttribute("xsi:type", "xsd:string");
		}
		return msg;
	}

	private SOAPElement getDispatchBodyElement(SOAPMessage msg, String operation)
			throws SOAPException {
		return (SOAPElement) msg.getSOAPBody()
				.getChildElements(new QName("http://www.otrs.org/TicketConnector/", operation)).next();//"/Core""Dispatch"
	}

	private SOAPMessage prepareSOAPMessage(Object obj, String stringObject, String method,
	                                       Map<String, Object> params) throws SOAPException {
		SOAPMessage msg = this.buildRPCMessage(method, stringObject == null);
		
		SOAPElement dispatch = null;
		
		if(stringObject == null){
			dispatch = this.getDispatchBodyElement(msg, method);
			
		} else {
			//Ansonsten das XML direkt in den Body schreiben
			dispatch = msg.getSOAPBody();
			
		}
		if(stringObject != null){
			SOAPElement soapElement = stringToSOAPElement(stringObject);
			dispatch.addChildElement(soapElement);
		} else if(obj != null) {
			Marshaller m;
			try {
				m = JaxbContext.getInstance().createMarshaller();
				m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MYNamespacePrefixMapper());
				m.marshal(obj, msg.getSOAPBody());
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			msg.getSOAPBody().addDocument(document)
			
		} 
		
		
//		dispatch.addChildElement("Data").addTextNode(object)
//				.setAttribute("xsi:type", "xsd:string");
//		dispatch.addChildElement("TicketID").addTextNode("1")
//				.setAttribute("xsi:type", "xsd:string");
		
		if(params == null)
			return msg;
		

		String[] keys = params.keySet().toArray(new String[params.keySet().size()]);

		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			Object value = params.get(key);
			
			if(value instanceof String) {
				dispatch.addChildElement(key).addTextNode((String) value)
				.setAttribute("xsi:type", "xsd:string");
				
	//			dispatch.addChildElement("Param" + i + "_Name").addTextNode(key)
	//					.setAttribute("xsi:type", "xsd:string");
				
			} else if (params.get(key) instanceof Collection<?>) {
				SOAPElement element = new SoapArrayFactory()
						.createSoapArray(key,
								(Collection<?>) params.get(key));
				dispatch.addChildElement(element);
			}
			
/**
			// Check if we need an array
			if (params.get(key).getClass().isArray()) {
				SOAPElement element = new SoapArrayFactory().createSoapArray(
						"Param" + i + "_Value", Arrays.asList(params.get(key)));
				dispatch.addChildElement(element);
				// collections will also be encoded as array
			} else if (params.get(key) instanceof Collection<?>) {
				SOAPElement element = new SoapArrayFactory()
						.createSoapArray("Param" + i + "_Value",
								(Collection<?>) params.get(key));
				dispatch.addChildElement(element);
				// maps need special encoding as well
			} else if (params.get(key) instanceof Map<?, ?>) {
				SOAPElement element = new SoapMapFactory().createSoapMap("Param" + i + "_Value", (Map<?, ?>) params.get(key));
				dispatch.addChildElement(element);
				// or a simple node
			} else {
				String xsdType = XSDTypeConverter.simpleTypeForObject(params.get(key));
				String value = params.get(key).toString();
				dispatch.addChildElement("Param" + i + "_Value")
						.addTextNode(value).setAttribute("xsi:type", xsdType);
			}
		*/
		}
		return msg;
	}
	
	public static SOAPElement stringToSOAPElement(String xmlText) {  
        try {  
            // Load the XML text into a DOM Document  
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();  
            builderFactory.setNamespaceAware(true);  
            InputStream stream  = new ByteArrayInputStream(xmlText.getBytes());  
            Document doc = builderFactory.newDocumentBuilder().parse(stream);   
   
            // Use SAAJ to convert Document to SOAPElement  
            // Create SoapMessage  
            MessageFactory msgFactory = MessageFactory.newInstance();  
            SOAPMessage    message    = msgFactory.createMessage();  
            SOAPBody       soapBody   = message.getSOAPBody();  
              
            // This returns the SOAPBodyElement   
            // that contains ONLY the Payload  
            return soapBody.addDocument(doc);  
            
        } catch (SOAPException  e) {  
            System.out.println("SOAPException : " + e);  
            return null;  
   
        } catch (IOException  e) {  
            System.out.println("IOException : " + e);  
            return null;  
   
        } catch (ParserConfigurationException  e) {  
            System.out.println("ParserConfigurationException : " + e);  
            return null;  
   
        } catch (SAXException  e) {  
            System.out.println("SAXException : " + e);  
            return null;  
   
        }  
    }  

	public SOAPMessage dispatchCall(Object object, String stringObject, String method,
	                                Map<String, Object> params) throws SOAPException, IOException {
		SOAPMessage msg = prepareSOAPMessage(object, stringObject, method, params);

		logMessage(msg);

//		MessageFactory mf = MessageFactory.newInstance(javax.xml.soap.SOAPConstants.SOAP_1_1_PROTOCOL);
		SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();
		
		SOAPConnection conn = scf.createConnection();
		
		SOAPMessage answerMsg = conn.call(msg, otrsUrl);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		answerMsg.writeTo(baos);
		
		String s = new String(baos.toByteArray());
		
		//Erzwingen, dass eine SOAP v 1.1. geparst wird
		MessageFactory m = MessageFactory.newInstance(javax.xml.soap.SOAPConstants.SOAP_1_1_PROTOCOL);
		SOAPMessage msg2 = m.createMessage(new MimeHeaders(), IOUtils.toInputStream(s));
		
		logMessage(msg2);
		return msg2;
	}

	private void logMessage(SOAPMessage msg) throws IOException,
			SOAPException {
		if (log.isDebugEnabled()) {
			// This will write the request to log
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			msg.writeTo(outputStream);
			byte[] byteArray = outputStream.toByteArray();
			String soapMsg = new String(byteArray, StandardCharsets.UTF_8);
			log.debug(soapMsg);
		}
	}
}
