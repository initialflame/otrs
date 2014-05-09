package de.ffn.otrs.client.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TicketCreateResponse", namespace="http://www.otrs.org/TicketConnector/")
public class TicketCreateResponse implements OTRSResponse {

	
	@XmlElement(name="Error")
	private Error error;
	
	@XmlElement(name="ArticleID")
	private String articleID;
	
	@XmlElement(name="TicketID")
	private String ticketID;

	@XmlElement(name="TicketNumber")
	private String tTicketNumber;
	

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

	public String gettTicketNumber() {
		return tTicketNumber;
	}

	public void settTicketNumber(String tTicketNumber) {
		this.tTicketNumber = tTicketNumber;
	}

}
