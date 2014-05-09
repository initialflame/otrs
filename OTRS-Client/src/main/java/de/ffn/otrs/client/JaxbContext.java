package de.ffn.otrs.client;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import de.ffn.otrs.client.objects.Attachment;
import de.ffn.otrs.client.objects.DynamicField;
import de.ffn.otrs.client.objects.PendingTime;
import de.ffn.otrs.client.objects.SessionCreate;
import de.ffn.otrs.client.objects.Ticket;
import de.ffn.otrs.client.objects.TicketCreate;
import de.ffn.otrs.client.objects.TicketCreateResponse;
import de.ffn.otrs.client.objects.TicketGet;
import de.ffn.otrs.client.objects.TicketGetResponse;
import de.ffn.otrs.client.objects.TicketSearch;
import de.ffn.otrs.client.objects.TicketSearchResponse;
import de.ffn.otrs.client.objects.TicketUpdate;
import de.ffn.otrs.client.objects.TicketUpdateResponse;

public class JaxbContext {

	
	private static JaxbContext instance = null;
	private JAXBContext jaxbCtx = null;

	
	private JaxbContext() throws JAXBException {
		super();
		
		jaxbCtx = JAXBContext.newInstance(
				Ticket.class, Attachment.class, DynamicField.class, PendingTime.class, SessionCreate.class, 
				TicketCreate.class, TicketGet.class, TicketSearch.class, TicketUpdate.class, 
				TicketSearchResponse.class, TicketGetResponse.class, TicketCreateResponse.class, TicketUpdateResponse.class);
		
	}



	public static JaxbContext getInstance() throws JAXBException {
		if(instance == null)
			instance = new JaxbContext();
		
		return instance;
	}
	
	
	public Marshaller createMarshaller(){
		try {
			Marshaller m = jaxbCtx.createMarshaller();
			m.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
			return m;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Unmarshaller createUnmarshaller(){
		try {
			return jaxbCtx.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String marshal(Object object) throws JAXBException{
		if(object != null){
			StringWriter sw = new StringWriter();
			createMarshaller().marshal(object, sw);
			String objectStr = sw.toString();
			return objectStr;
		}
		return null;
	}
	
	public Object unmarshal(String string) throws JAXBException{
		if(string != null){
			StringReader sw = new StringReader(string);
			Object obj = createUnmarshaller().unmarshal(sw);
			return obj;
		}
		return null;
	}
	
	
}
