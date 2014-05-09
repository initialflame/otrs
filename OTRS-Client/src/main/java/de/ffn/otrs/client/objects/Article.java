package de.ffn.otrs.client.objects;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 * <Article>
					<Age>109117722</Age>
					<AgeTimeUnix>658509</AgeTimeUnix>
					<ArticleID>1</ArticleID>
					<ArticleType>email-external</ArticleType>
					<ArticleTypeID>1</ArticleTypeID>
					<Body>Welcome!

Thank you for installing OTRS.

You will find updates and patches at http://www.otrs.com/open-source/.
Online documentation is available at http://doc.otrs.org/.
You can also use our mailing lists http://lists.otrs.org/
or our forums at http://forums.otrs.org/

Regards,

The OTRS Project
</Body>
					<Cc/>
					<Changed>2014-01-14 15:29:00</Changed>
					<Charset/>
					<ContentCharset/>
					<ContentType/>
					<CreateTimeUnix>1280750400</CreateTimeUnix>
					<Created>2010-08-02 14:00:00</Created>
					<CreatedBy>1</CreatedBy>
					<CustomerID/>
					<CustomerUserID/>
					<EscalationResponseTime>0</EscalationResponseTime>
					<EscalationSolutionTime>0</EscalationSolutionTime>
					<EscalationTime>0</EscalationTime>
					<EscalationUpdateTime>0</EscalationUpdateTime>
					<From>OTRS Feedback feedbackotrs.org</From>
					<FromRealname>OTRS Feedback</FromRealname>
					<InReplyTo/>
					<IncomingTime>1280750400</IncomingTime>
					<Lock>unlock</Lock>
					<LockID>1</LockID>
					<MessageID>007@localhost</MessageID>
					<MimeType/>
					<Owner>userrowner</Owner>
					<OwnerID>2</OwnerID>
					<Priority>3 normal</Priority>
					<PriorityID>3</PriorityID>
					<Queue>Raw</Queue>
					<QueueID>2</QueueID>
					<RealTillTimeNotUsed>0</RealTillTimeNotUsed>
					<References/>
					<ReplyTo/>
					<Responsible>root@localhost</Responsible>
					<ResponsibleID>1</ResponsibleID>
					<SLA/>
					<SLAID/>
					<SenderType>customer</SenderType>
					<SenderTypeID>3</SenderTypeID>
					<Service/>
					<ServiceID/>
					<State>new</State>
					<StateID>1</StateID>
					<StateType>new</StateType>
					<Subject>Welcome to OTRS!</Subject>
					<TicketID>1</TicketID>
					<TicketNumber>2010080210123456</TicketNumber>
					<Title>Welcome to OTRS!</Title>
					<To>Your OTRS System otrs@localhost</To>
					<ToRealname>Your OTRS System</ToRealname>
					<Type>Unclassified</Type>
					<TypeID/>
					<UntilTime>0</UntilTime>
				</Article>
 * 
 * @author sk0007
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Article")
public class Article {
	
	@XmlElement(name="Age")
	private Long age; 
	
	@XmlElement(name="AgeTimeUnix")
	private Long ageTimeUnix; 
	
	@XmlElement(name="TicketID")
	private String ticketID;
	
	@XmlElement(name="TicketNumber")
	private String ticketNumber;
	
	@XmlElement(name="ArticleID")
	private Long articleID;
	
	@XmlElement(name="ArticleTypeID")
	private String articleTypeID;
	
	@XmlElement(name="ArticleType")
	private String articleType;
	
	@XmlElement(name="SenderTypeID")
	private String senderTypeID;
	
	@XmlElement(name="SenderType")
	private String senderType;
	
	@XmlElement(name="MessageID")
	private String messageID;
	
	@XmlElement(name="From")
	private String from;
	
	@XmlElement(name="FromRealname")
	private String fromRealname;
	
	@XmlElement(name="To")
	private String to;
	
	@XmlElement(name="ToRealname")
	private String toRealname;
	
	@XmlElement(name="ReplyTo")
	private String ReplyTo;
	
	@XmlElement(name="InReplyTo")
	private String inReplyTo;
	
	@XmlElement(name="Lock")
	private String lock;
	
	@XmlElement(name="LockID")
	private Long lockID;
	
	@XmlElement(name="IncomingTime")
	private String incomingTime;
	
	@XmlElement(name="Subject")
	private String subject;
	
	@XmlElement(name="Body")
	private String body;
	
	@XmlElement(name="ContentType")
	private String contentType;
	
	@XmlElement(name="Charset")
	private String charset;
	
	@XmlElement(name="MimeType")
	private String mimeType;
	
	@XmlElement(name="OwnerID")
	private String ownerID;
	
	@XmlElement(name="Owner")
	private String owner;
	
	@XmlElement(name="ResponsibleID")
	private String responsibleID;
	
	@XmlElement(name="Responsible")
	private String responsible;
	
	@XmlElement(name="Changed")
	@XmlJavaTypeAdapter(de.ffn.otrs.client.OTRSDateAdapter.class)
	private Date  changed;
	
	@XmlElement(name="CreatedBy")
	private String createdBy;
	
	@XmlElement(name="CreateTimeUnix")
	private Long createTimeUnix;
	
	@XmlElement(name="Created")
	@XmlJavaTypeAdapter(de.ffn.otrs.client.OTRSDateAdapter.class)
	private Date created;
	
	@XmlElement(name="EscalationResponseTime")
	private Long escalationResponseTime;
	
	@XmlElement(name="EscalationSolutionTime")
	private Long escalationSolutionTime;
	
	@XmlElement(name="EscalationTime")
	private Long escalationTime;
	
	@XmlElement(name="EscalationUpdateTime")
	private Long EscalationUpdateTime;
	
	@XmlElement(name="HistoryType")
	private String historyType;
	
	@XmlElement(name="HistoryComment")
	private String historyComment;
	
	@XmlElement(name="AutoResponseType")
	private String autoResponseType;
	
	@XmlElement(name="TimeUnit")
	private String timeUnit;
	
	/**
	 * if you don't want to send agent notifications
	 */
	@XmlElement(name="NoAgentNotify")
	private Integer noAgentNotify;
	
	@XmlElement(name="ForceNotificationToUserID")
	private String forceNotificationToUserID;
	
	@XmlElement(name="ExcludeNotificationToUserID")
	private String excludeNotificationToUserID;
	
	@XmlElement(name="ExcludeMuteNotificationToUserID")
	private String excludeMuteNotificationToUserID;

	public String getArticleTypeID() {
		return articleTypeID;
	}

	public void setArticleTypeID(String articleTypeID) {
		this.articleTypeID = articleTypeID;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getSenderTypeID() {
		return senderTypeID;
	}

	public void setSenderTypeID(String senderTypeID) {
		this.senderTypeID = senderTypeID;
	}

	public String getSenderType() {
		return senderType;
	}

	public void setSenderType(String senderType) {
		this.senderType = senderType;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getHistoryType() {
		return historyType;
	}

	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}

	public String getHistoryComment() {
		return historyComment;
	}

	public void setHistoryComment(String historyComment) {
		this.historyComment = historyComment;
	}

	public String getAutoResponseType() {
		return autoResponseType;
	}

	public void setAutoResponseType(String autoResponseType) {
		this.autoResponseType = autoResponseType;
	}

	public String getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}

	public Integer getNoAgentNotify() {
		return noAgentNotify;
	}

	public void setNoAgentNotify(Integer noAgentNotify) {
		this.noAgentNotify = noAgentNotify;
	}

	public String getForceNotificationToUserID() {
		return forceNotificationToUserID;
	}

	public void setForceNotificationToUserID(String forceNotificationToUserID) {
		this.forceNotificationToUserID = forceNotificationToUserID;
	}

	public String getExcludeNotificationToUserID() {
		return excludeNotificationToUserID;
	}

	public void setExcludeNotificationToUserID(String excludeNotificationToUserID) {
		this.excludeNotificationToUserID = excludeNotificationToUserID;
	}

	public String getExcludeMuteNotificationToUserID() {
		return excludeMuteNotificationToUserID;
	}

	public void setExcludeMuteNotificationToUserID(
			String excludeMuteNotificationToUserID) {
		this.excludeMuteNotificationToUserID = excludeMuteNotificationToUserID;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Long getAgeTimeUnix() {
		return ageTimeUnix;
	}

	public void setAgeTimeUnix(Long ageTimeUnix) {
		this.ageTimeUnix = ageTimeUnix;
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

	public Long getArticleID() {
		return articleID;
	}

	public void setArticleID(Long articleID) {
		this.articleID = articleID;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getFromRealname() {
		return fromRealname;
	}

	public void setFromRealname(String fromRealname) {
		this.fromRealname = fromRealname;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getToRealname() {
		return toRealname;
	}

	public void setToRealname(String toRealname) {
		this.toRealname = toRealname;
	}

	public String getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(String inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	public String getLock() {
		return lock;
	}

	public void setLock(String lock) {
		this.lock = lock;
	}

	public Long getLockID() {
		return lockID;
	}

	public void setLockID(Long lockID) {
		this.lockID = lockID;
	}

	public String getIncomingTime() {
		return incomingTime;
	}

	public void setIncomingTime(String incomingTime) {
		this.incomingTime = incomingTime;
	}

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getResponsibleID() {
		return responsibleID;
	}

	public void setResponsibleID(String responsibleID) {
		this.responsibleID = responsibleID;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public Date getChanged() {
		return changed;
	}

	public void setChanged(Date changed) {
		this.changed = changed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getCreateTimeUnix() {
		return createTimeUnix;
	}

	public void setCreateTimeUnix(Long createTimeUnix) {
		this.createTimeUnix = createTimeUnix;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getEscalationResponseTime() {
		return escalationResponseTime;
	}

	public void setEscalationResponseTime(Long escalationResponseTime) {
		this.escalationResponseTime = escalationResponseTime;
	}

	public Long getEscalationSolutionTime() {
		return escalationSolutionTime;
	}

	public void setEscalationSolutionTime(Long escalationSolutionTime) {
		this.escalationSolutionTime = escalationSolutionTime;
	}

	public Long getEscalationTime() {
		return escalationTime;
	}

	public void setEscalationTime(Long escalationTime) {
		this.escalationTime = escalationTime;
	}

	public Long getEscalationUpdateTime() {
		return EscalationUpdateTime;
	}

	public void setEscalationUpdateTime(Long escalationUpdateTime) {
		EscalationUpdateTime = escalationUpdateTime;
	}

	public String getReplyTo() {
		return ReplyTo;
	}

	public void setReplyTo(String replyTo) {
		ReplyTo = replyTo;
	}
	
}
