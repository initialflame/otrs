
package de.ffn.otrs.client.objects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TicketGet")
public class TicketGet implements OTRSRequest {
	
	
	@XmlElement(name="UserLogin")
	private String userLogin;
	
	@XmlElement(name="CustomerUserLogin")
	private String customerUserLogin;
	
	@XmlElement(name="SessionID")
	private String sessionID;
	
	@XmlElement(name="Password")
	private String password;
	
	@XmlElement(name="TicketID")
	private List<String> ticketIDs;
	
	@XmlElement(name="DynamicFields")
	private List<DynamicField> dynamicFields;
	
	@XmlElement(name="Extended")
	private String extended;
	
	@XmlElement(name="AllArticles")
	private String allArticles;
	
	@XmlElement(name="ArticleSenderType")
	private String articleSenderType;
	
	@XmlElement(name="ArticleOrder")
	private String articleOrder;
	
	@XmlElement(name="ArticleLimit")
	private String articleLimit;
	
	@XmlElement(name="Attachments")
	private String attachments;
	
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getCustomerUserLogin() {
		return customerUserLogin;
	}
	public void setCustomerUserLogin(String customerUserLogin) {
		this.customerUserLogin = customerUserLogin;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<String> getTicketIDs() {
		return ticketIDs;
	}
	public void setTicketIDs(List<String> ticketIDs) {
		this.ticketIDs = ticketIDs;
	}
	public String getTicketID() {
		if(ticketIDs != null 
				&& ticketIDs.size() >= 1)
			return ticketIDs.get(0);
		
		return null;
	}
	public void addTicketID(String ticketID) {
		if(ticketIDs ==null)
			ticketIDs = new ArrayList<String>();
		this.ticketIDs.add(ticketID);
	}
	public List<DynamicField> getDynamicFields() {
		return dynamicFields;
	}
	public void setDynamicFields(List<DynamicField> dynamicFields) {
		this.dynamicFields = dynamicFields;
	}
	public String getExtended() {
		return extended;
	}
	public void setExtended(String extended) {
		this.extended = extended;
	}
	public String getAllArticles() {
		return allArticles;
	}
	public void setAllArticles(String allArticles) {
		this.allArticles = allArticles;
	}
	public String getArticleSenderType() {
		return articleSenderType;
	}
	public void setArticleSenderType(String articleSenderType) {
		this.articleSenderType = articleSenderType;
	}
	public String getArticleOrder() {
		return articleOrder;
	}
	public void setArticleOrder(String articleOrder) {
		this.articleOrder = articleOrder;
	}
	public String getArticleLimit() {
		return articleLimit;
	}
	public void setArticleLimit(String articleLimit) {
		this.articleLimit = articleLimit;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	
}
