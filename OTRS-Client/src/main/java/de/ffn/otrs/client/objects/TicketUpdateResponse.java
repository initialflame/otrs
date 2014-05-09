package de.ffn.otrs.client.objects;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TicketUpdateResponse", namespace="http://www.otrs.org/TicketConnector/")
public class TicketUpdateResponse implements OTRSResponse {

	
	@XmlElement(name="Ticket")
	private List<Ticket> tickets;
	
	@XmlElement(name="Error")
	private Error error;
	
	@XmlElement(name="ArticleID")
	private String articleID;
	
	@XmlElement(name="TicketID")
	private String ticketID;

	@XmlElement(name="TicketNumber")
	private String ticketNumber;
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public String getArticleID() {
		return articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

}
