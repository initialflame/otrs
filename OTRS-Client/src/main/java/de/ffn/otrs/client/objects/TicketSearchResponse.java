package de.ffn.otrs.client.objects;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TicketSearchResponse", namespace="http://www.otrs.org/TicketConnector/")
public class TicketSearchResponse implements OTRSResponse {

	
	@XmlElement(name="TicketID")
	private List<String> ticketIDs;
	
	@XmlElement(name="Error")
	private Error error;

	
	public List<String> getTicketIDs() {
		return ticketIDs;
	}

	public void setTicketIDs(List<String> ticketIDs) {
		this.ticketIDs = ticketIDs;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	
}
