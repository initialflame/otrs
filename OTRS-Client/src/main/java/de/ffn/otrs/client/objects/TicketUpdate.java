package de.ffn.otrs.client.objects;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *       <TicketUpdate>
         <!--You have a MANDATORY CHOICE of the next 3 items at this level-->
         <!--Optional:-->
         <UserLogin>?</UserLogin>
         <!--Optional:-->
         <CustomerUserLogin>?</CustomerUserLogin>
         <!--Optional:-->
         <SessionID>?</SessionID>
         <!--Optional:-->
         <Password>?</Password>
         <!--You have a CHOICE of the next 2 items at this level-->
         <TicketID>?</TicketID>
         <TicketNumber>?</TicketNumber>
         <!--Optional:-->
         <Ticket>
            <!--Optional:-->
            <Title>?</Title>
            <!--You have a CHOICE of the next 2 items at this level-->
            <!--Optional:-->
            <QueueID>?</QueueID>
            <!--Optional:-->
            <Queue>?</Queue>
            <!--You have a CHOICE of the next 2 items at this level-->
            <!--Optional:-->
            <TypeID>?</TypeID>
            <!--Optional:-->
            <Type>?</Type>
            <!--You have a CHOICE of the next 2 items at this level-->
            <!--Optional:-->
            <ServiceID>?</ServiceID>
            <!--Optional:-->
            <Service>?</Service>
            <!--You have a CHOICE of the next 2 items at this level-->
            <!--Optional:-->
            <SLAID>?</SLAID>
            <!--Optional:-->
            <SLA>?</SLA>
            <!--You have a CHOICE of the next 2 items at this level-->
            <!--Optional:-->
            <StateID>?</StateID>
            <!--Optional:-->
            <State>?</State>
            <!--You have a CHOICE of the next 2 items at this level-->
            <!--Optional:-->
            <PriorityID>?</PriorityID>
            <!--Optional:-->
            <Priority>?</Priority>
            <!--You have a CHOICE of the next 2 items at this level-->
            <!--Optional:-->
            <OwnerID>?</OwnerID>
            <!--Optional:-->
            <Owner>?</Owner>
            <!--You have a CHOICE of the next 2 items at this level-->
            <!--Optional:-->
            <ResponsibleID>?</ResponsibleID>
            <!--Optional:-->
            <Responsible>?</Responsible>
            <!--Optional:-->
            <CustomerUser>?</CustomerUser>
            <!--Optional:-->
            <PendingTime>
               <Year>?</Year>
               <Month>?</Month>
               <Day>?</Day>
               <Hour>?</Hour>
               <Minute>?</Minute>
            </PendingTime>
         </Ticket>
         <!--Optional:-->
         <Article>
            <!--You have a CHOICE of the next 2 items at this level-->
            <!--Optional:-->
            <ArticleTypeID>?</ArticleTypeID>
            <!--Optional:-->
            <ArticleType>?</ArticleType>
            <!--You have a CHOICE of the next 2 items at this level-->
            <!--Optional:-->
            <SenderTypeID>?</SenderTypeID>
            <!--Optional:-->
            <SenderType>?</SenderType>
            <!--Optional:-->
            <From>?</From>
            <Subject>?</Subject>
            <Body>?</Body>
            <!--You have a CHOICE of the next 2 items at this level-->
            <!--Optional:-->
            <ContentType>?</ContentType>
            <Charset>?</Charset>
            <MimeType>?</MimeType>
            <!--Optional:-->
            <HistoryType>?</HistoryType>
            <!--Optional:-->
            <HistoryComment>?</HistoryComment>
            <!--Optional:-->
            <AutoResponseType>?</AutoResponseType>
            <!--Optional:-->
            <TimeUnit>?</TimeUnit>
            <!--Optional:-->
            <NoAgentNotify>?</NoAgentNotify>
            <!--Zero or more repetitions:-->
            <ForceNotificationToUserID>?</ForceNotificationToUserID>
            <!--Zero or more repetitions:-->
            <ExcludeNotificationToUserID>?</ExcludeNotificationToUserID>
            <!--Zero or more repetitions:-->
            <ExcludeMuteNotificationToUserID>?</ExcludeMuteNotificationToUserID>
         </Article>
         <!--Zero or more repetitions:-->
         <DynamicField>
            <Name>?</Name>
            <!--1 or more repetitions:-->
            <Value>?</Value>
         </DynamicField>
         <!--Zero or more repetitions:-->
         <Attachment>
            <Content>cid:166861569966</Content>
            <ContentType>?</ContentType>
            <Filename>?</Filename>
         </Attachment>
      </TicketUpdate>
 * @author sk0007
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TicketUpdate")
public class TicketUpdate implements OTRSRequest {

	@XmlElement(name="UserLogin")
	private String userLogin;
	
	@XmlElement(name="CustomerUserLogin")
	private String customerUserLogin;
	
	@XmlElement(name="SessionID")
	private String sessionID;
	
	@XmlElement(name="Password")
	private String password;

	@XmlElement(name="TicketID")
	private String ticketID;

	@XmlElement(name="TicketNumber")
	private String ticketNumber;
	
	@XmlElement(name="Ticket")
	private Ticket ticket;
	
	@XmlElement(name="Article")
	private Article article;
	
	@XmlElement(name="DynamicField")
    private List<DynamicField> dynamicFields;
    
	@XmlElement(name="Attachment")
    private List<Attachment> attachments;

	
	public TicketUpdate() {
		super();
	}

	public TicketUpdate(Ticket ticket) {
		super();
		this.ticket = ticket;
		this.ticketID = ticket.getTicketID();
		this.ticketNumber = ticket.getTicketNumber();
	}

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

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public List<DynamicField> getDynamicFields() {
		return dynamicFields;
	}

	public void setDynamicFields(List<DynamicField> dynamicFields) {
		this.dynamicFields = dynamicFields;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
}
