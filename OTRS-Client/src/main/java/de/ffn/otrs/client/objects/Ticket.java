package de.ffn.otrs.client.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 * <Ticket>
       <Title>?</Title>
       <!--You have a MANDATORY CHOICE of the next 2 items at this level-->
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
       <!--You have a MANDATORY CHOICE of the next 2 items at this level-->
       <!--Optional:-->
       <StateID>?</StateID>
       <!--Optional:-->
       <State>?</State>
       <!--You have a MANDATORY CHOICE of the next 2 items at this level-->
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
 * @author sk0007
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Ticket")
public class Ticket {
	
	@XmlElement(name="Title")
	private String title;
	
	@XmlElement(name="TicketID")
	private String ticketID;
	
	@XmlElement(name="TicketNumber")
	private String ticketNumber;
	
	@XmlElement(name="CustomerUser")
	private String customerUser;
	
	@XmlElement(name="CustomerID")
	private String customerID;
	
	@XmlElement(name="CustomerUserID")
	private String customerUserID;
	
	@XmlElement(name="Age")
	private Long age;
	
	@XmlElement(name="ArchiveFlag")
	private String  archiveFlag;
	
	@XmlElement(name="ChangeBy")
	private String  changeBy;
	
	@XmlElement(name="Changed")
	@XmlJavaTypeAdapter(de.ffn.otrs.client.OTRSDateAdapter.class)
	private Date  changed;
	
	@XmlElement(name="CreateBy")
	private String createBy;
	
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
	
	@XmlElement(name="GroupID")
	private Long GroupID;
	
	@XmlElement(name="Lock")
	private String lock;
	
	@XmlElement(name="LockID")
	private Long lockID;
	
	@XmlElement(name="UnlockTimeout")
	private Long unlockTimeout;
	
	@XmlElement(name="UntilTime")
	private Long untilTime;
	
	@XmlElement(name="QueueID")
	private String queueID;
	
	@XmlElement(name="Queue")
	private String queue;
	
	@XmlElement(name="RealTillTimeNotUsed")
	private Long realTillTimeNotUsed;
	
	@XmlElement(name="TypeID")
	private String typeID;
	
	@XmlElement(name="Type")
	private String type;
	
	@XmlElement(name="ServiceID")
	private String serviceID;
	
	@XmlElement(name="Service")
	private String service;
	
	@XmlElement(name="SLAID")
	private String sLAID ;
	
	@XmlElement(name="SLA")
	private String sLA;
	
	@XmlElement(name="StateID")
	private String stateID;
	
	@XmlElement(name="State")
	private String state;
	
	@XmlElement(name="PriorityID")
	private String priorityID;
	
	@XmlElement(name="Priority")
	private String priority;
	
	@XmlElement(name="OwnerID")
	private String ownerID;
	
	@XmlElement(name="Owner")
	private String owner;
	
	@XmlElement(name="ResponsibleID")
	private String responsibleID;
	
	@XmlElement(name="Responsible")
	private String responsible;
	
	@XmlElement(name="PendingTime")
	private PendingTime pendingTime;
	
	@XmlElement(name="Article")
	private List<Article> articles;

	@XmlElement(name="DynamicField")
	private List<DynamicField> dynamicFields;
	
	
	public String getQueueID() {
		return queueID;
	}

	public void setQueueID(String queueID) {
		this.queueID = queueID;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getServiceID() {
		return serviceID;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getsLAID() {
		return sLAID;
	}

	public void setsLAID(String sLAID) {
		this.sLAID = sLAID;
	}

	public String getsLA() {
		return sLA;
	}

	public void setsLA(String sLA) {
		this.sLA = sLA;
	}

	public String getStateID() {
		return stateID;
	}

	public void setStateID(String stateID) {
		this.stateID = stateID;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPriorityID() {
		return priorityID;
	}

	public void setPriorityID(String priorityID) {
		this.priorityID = priorityID;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
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

	public String getCustomerUser() {
		return customerUser;
	}

	public void setCustomerUser(String customerUser) {
		this.customerUser = customerUser;
	}

	public PendingTime getPendingTime() {
		return pendingTime;
	}

	public void setPendingTime(PendingTime pendingTime) {
		this.pendingTime = pendingTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerUserID() {
		return customerUserID;
	}

	public void setCustomerUserID(String customerUserID) {
		this.customerUserID = customerUserID;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getArchiveFlag() {
		return archiveFlag;
	}

	public void setArchiveFlag(String archiveFlag) {
		this.archiveFlag = archiveFlag;
	}

	public String getChangeBy() {
		return changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	public Date getChanged() {
		return changed;
	}

	public void setChanged(Date changed) {
		this.changed = changed;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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

	public Long getGroupID() {
		return GroupID;
	}

	public void setGroupID(Long groupID) {
		GroupID = groupID;
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

	public Long getUnlockTimeout() {
		return unlockTimeout;
	}

	public void setUnlockTimeout(Long unlockTimeout) {
		this.unlockTimeout = unlockTimeout;
	}

	public Long getUntilTime() {
		return untilTime;
	}

	public void setUntilTime(Long untilTime) {
		this.untilTime = untilTime;
	}

	public Long getRealTillTimeNotUsed() {
		return realTillTimeNotUsed;
	}

	public void setRealTillTimeNotUsed(Long realTillTimeNotUsed) {
		this.realTillTimeNotUsed = realTillTimeNotUsed;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public void addArticle(Article article){
		if(articles== null)
			articles = new ArrayList<Article>();
		articles.add(article);
	}

	public List<DynamicField> getDynamicFields() {
		return dynamicFields;
	}

	public void setDynamicFields(List<DynamicField> dynamicFields) {
		this.dynamicFields = dynamicFields;
	}
	
	public void addDynamicFields(List<DynamicField> fields) {
		if(dynamicFields == null)
			this.dynamicFields = fields;
		else 
			this.dynamicFields.addAll(fields);
	}
	
	
}
