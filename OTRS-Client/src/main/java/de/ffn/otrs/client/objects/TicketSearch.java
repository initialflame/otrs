package de.ffn.otrs.client.objects;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TicketSearch")
public class TicketSearch implements OTRSRequest {
	
	
	@XmlElement(name="UserLogin" )
	private String userLogin;
	
	@XmlElement(name="CustomerUserLogin" )
	private String customerUserLogin;
	
	@XmlElement(name="SessionID" )
	private String sessionID;
	
	@XmlElement(name="Password" )
	private String password;
	
	@XmlElement(name="Limit" )
	private Integer limit;
	
	@XmlElement(name="TicketNumber" )
	private String ticketNumber;
	
	@XmlElement(name="Title" )
	private String title;
	
	@XmlElement(name="Queues" )
	private List<String> queues;
	
	@XmlElement(name="QueueIDs" )
	private List<String> queueIDs;
	
	@XmlElement(name="UseSubQueues" )
	private String useSubQueues;
	@XmlElement(name="Types" )
	private List<String> types;
	@XmlElement(name="TypeIDs" )
	private List<String> typeIDs;
	@XmlElement(name="States" )
	private List<String> states;
	@XmlElement(name="StateIDs" )
	private List<String> stateIDs;
	@XmlElement(name="StateType" )
	private List<String> stateType;
	@XmlElement(name="StateTypeIDs" )
	private List<String> stateTypeIDs;
	@XmlElement(name="Priorities" )
	private List<String> Priorities;
	@XmlElement(name="PriorityIDs" )
	private List<String> priorityIDs;
	@XmlElement(name="Services" )
	private List<String> services;
	@XmlElement(name="ServiceIDs" )
	private List<String> serviceIDs;
	@XmlElement(name="SLAs" )
	private List<String> sLAs;
	@XmlElement(name="SLAIDs" )
	private List<String> sLAIDs;
	@XmlElement(name="Locks" )
	private List<String> locks;
	@XmlElement(name="LockIDs" )
	private List<String> lockIDs;
	@XmlElement(name="OwnerIDs" )
	private List<String> ownerIDs;
	@XmlElement(name="ResponsibleIDs" )
	private List<String> responsibleIDs;
	@XmlElement(name="WatchUserIDs" )
	private List<String> watchUserIDs;
	@XmlElement(name="CustomerID" )
	private String customerID;
	@XmlElement(name="CustomerUserLogin" )
	private String CustomerUserLogin;
	@XmlElement(name="CreatedUserIDs" )
	private List<String> createdUserIDs;
	@XmlElement(name="CreatedTypes" )
	private List<String> createdTypes;
	@XmlElement(name="CreatedTypeIDs" )
	private List<String> createdTypeIDs;
	@XmlElement(name="CreatedPriorities" )
	private List<String> createdPriorities;
	@XmlElement(name="createdPriorityIDs" )
	private List<String> createdPriorityIDs;
	@XmlElement(name="CreatedStates" )
	private List<String> createdStates;
	@XmlElement(name="CreatedStateIDs" )
	private List<String> createdStateIDs;
	@XmlElement(name="CreatedQueues" )
	private List<String> createdQueues;
	@XmlElement(name="CreatedQueueIDs" )
	private List<String> createdQueueIDs;
	
	@XmlElement(name="DynamicField" )
	private List<DynamicField> dynamicField;
	/**
	 *  <DynamicFields>
            <!--You have a MANDATORY CHOICE of the next 6 items at this level-->
            <!--Optional:-->
            <Equals>?</Equals>
            <!--Optional:-->
            <Like>?</Like>
            <!--Optional:-->
            <GreaterThan>?</GreaterThan>
            <!--Optional:-->
            <GreaterThanEquals>?</GreaterThanEquals>
            <!--Optional:-->
            <SmallerThan>?</SmallerThan>
            <!--Optional:-->
            <SmallerThanEquals>?</SmallerThanEquals>
         </DynamicFields>
	 */
	@XmlElement(name="Ticketflag" )
	private TicketFlag ticketflag;
	@XmlElement(name="From" )
	private String from;
	@XmlElement(name="To" )
	private String to;
	@XmlElement(name="Cc" )
	private String cc;
	@XmlElement(name="Subject" )
	private String subject;
	@XmlElement(name="Body" )
	private String body;
	@XmlElement(name="FullTextIndex" )
	private String fullTextIndex;
	@XmlElement(name="ContentSearch" )
	private String contentSearch;
	@XmlElement(name="ConditionInline" )
	private String conditionInline;
	@XmlElement(name="ArticleCreateTimeOlderMinutes" )
	private String articleCreateTimeOlderMinutes;
	@XmlElement(name="ArticleCreateTimeNewerMinutes" )
	private String articleCreateTimeNewerMinutes;
	@XmlElement(name="ArticleCreateTimeNewerDate" )
	private String articleCreateTimeNewerDate;
	@XmlElement(name="ArticleCreateTimeOlderDate" )
	private String articleCreateTimeOlderDate;
	@XmlElement(name="TicketCreateTimeOlderMinutes" )
	private String ticketCreateTimeOlderMinutes;
	@XmlElement(name="ATicketCreateTimeNewerMinutes" )
	private String aTicketCreateTimeNewerMinutes;
	@XmlElement(name="TicketCreateTimeNewerDate" )
	private String ticketCreateTimeNewerDate;
	@XmlElement(name="TicketCreateTimeOlderDate" )
	private String ticketCreateTimeOlderDate;
	@XmlElement(name="TicketChangeTimeOlderMinutes" )
	private String ticketChangeTimeOlderMinutes;
	@XmlElement(name="TicketChangeTimeNewerMinutes" )
	private String ticketChangeTimeNewerMinutes;
	@XmlElement(name="TicketChangeTimeNewerDate" )
	private String ticketChangeTimeNewerDate;
	@XmlElement(name="TicketChangeTimeOlderDate" )
	private String ticketChangeTimeOlderDate;
	@XmlElement(name="TicketCloseTimeOlderMinutes" )
	private String ticketCloseTimeOlderMinutes;
	@XmlElement(name="TicketCloseTimeNewerMinutes" )
	private String ticketCloseTimeNewerMinutes;
	@XmlElement(name="TicketCloseTimeNewerDate" )
	private String ticketCloseTimeNewerDate;
	@XmlElement(name="TicketCloseTimeOlderDate" )
	private String ticketCloseTimeOlderDate;
	@XmlElement(name="TicketPendingTimeOlderMinutes" )
	private String ticketPendingTimeOlderMinutes;
	@XmlElement(name="TicketPendingTimeNewerMinutes" )
	private String ticketPendingTimeNewerMinutes;
	@XmlElement(name="TicketPendingTimeNewerDate" )
	private String ticketPendingTimeNewerDate;
	@XmlElement(name="TicketPendingTimeOlderDate" )
	private String ticketPendingTimeOlderDate;
	@XmlElement(name="TicketEscalationTimeOlderMinutes" )
	private String ticketEscalationTimeOlderMinutes;
	@XmlElement(name="TicketEscalationTimeNewerMinutes" )
	private String ticketEscalationTimeNewerMinutes;
	@XmlElement(name="TicketEscalationTimeNewerDate" )
	private String ticketEscalationTimeNewerDate;
	@XmlElement(name="TicketEscalationTimeOlderDate" )
	private String ticketEscalationTimeOlderDate;
	@XmlElement(name="ArchiveFlags" )
	private List<String> archiveFlags;
	@XmlElement(name="OrderBy" )
	private List<String> orderBy;
	@XmlElement(name="SortBy" )
	private List<String> sortBy;
	@XmlElement(name="CustomerUserID" )
	private List<String> customerUserID;
	

	
	
	
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
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getQueues() {
		return queues;
	}
	public void setQueues(List<String> queues) {
		this.queues = queues;
	}
	public List<String> getQueueIDs() {
		return queueIDs;
	}
	public void setQueueIDs(List<String> queueIDs) {
		this.queueIDs = queueIDs;
	}
	public String getUseSubQueues() {
		return useSubQueues;
	}
	public void setUseSubQueues(String useSubQueues) {
		this.useSubQueues = useSubQueues;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public List<String> getTypeIDs() {
		return typeIDs;
	}
	public void setTypeIDs(List<String> typeIDs) {
		this.typeIDs = typeIDs;
	}
	public List<String> getStates() {
		return states;
	}
	public void setStates(List<String> states) {
		this.states = states;
	}
	public List<String> getStateIDs() {
		return stateIDs;
	}
	public void setStateIDs(List<String> stateIDs) {
		this.stateIDs = stateIDs;
	}
	public List<String> getStateType() {
		return stateType;
	}
	public void setStateType(List<String> stateType) {
		this.stateType = stateType;
	}
	public List<String> getStateTypeIDs() {
		return stateTypeIDs;
	}
	public void setStateTypeIDs(List<String> stateTypeIDs) {
		this.stateTypeIDs = stateTypeIDs;
	}
	public List<String> getPriorities() {
		return Priorities;
	}
	public void setPriorities(List<String> priorities) {
		Priorities = priorities;
	}
	public List<String> getPriorityIDs() {
		return priorityIDs;
	}
	public void setPriorityIDs(List<String> priorityIDs) {
		this.priorityIDs = priorityIDs;
	}
	public List<String> getServices() {
		return services;
	}
	public void setServices(List<String> services) {
		this.services = services;
	}
	public List<String> getServiceIDs() {
		return serviceIDs;
	}
	public void setServiceIDs(List<String> serviceIDs) {
		this.serviceIDs = serviceIDs;
	}
	public List<String> getsLAs() {
		return sLAs;
	}
	public void setsLAs(List<String> sLAs) {
		this.sLAs = sLAs;
	}
	public List<String> getsLAIDs() {
		return sLAIDs;
	}
	public void setsLAIDs(List<String> sLAIDs) {
		this.sLAIDs = sLAIDs;
	}
	public List<String> getLocks() {
		return locks;
	}
	public void setLocks(List<String> locks) {
		this.locks = locks;
	}
	public List<String> getLockIDs() {
		return lockIDs;
	}
	public void setLockIDs(List<String> lockIDs) {
		this.lockIDs = lockIDs;
	}
	public List<String> getOwnerIDs() {
		return ownerIDs;
	}
	public void setOwnerIDs(List<String> ownerIDs) {
		this.ownerIDs = ownerIDs;
	}
	public List<String> getResponsibleIDs() {
		return responsibleIDs;
	}
	public void setResponsibleIDs(List<String> responsibleIDs) {
		this.responsibleIDs = responsibleIDs;
	}
	public List<String> getWatchUserIDs() {
		return watchUserIDs;
	}
	public void setWatchUserIDs(List<String> watchUserIDs) {
		this.watchUserIDs = watchUserIDs;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public List<String> getCreatedUserIDs() {
		return createdUserIDs;
	}
	public void setCreatedUserIDs(List<String> createdUserIDs) {
		this.createdUserIDs = createdUserIDs;
	}
	public List<String> getCreatedTypes() {
		return createdTypes;
	}
	public void setCreatedTypes(List<String> createdTypes) {
		this.createdTypes = createdTypes;
	}
	public List<String> getCreatedTypeIDs() {
		return createdTypeIDs;
	}
	public void setCreatedTypeIDs(List<String> createdTypeIDs) {
		this.createdTypeIDs = createdTypeIDs;
	}
	public List<String> getCreatedPriorities() {
		return createdPriorities;
	}
	public void setCreatedPriorities(List<String> createdPriorities) {
		this.createdPriorities = createdPriorities;
	}
	public List<String> getCreatedPriorityIDs() {
		return createdPriorityIDs;
	}
	public void setCreatedPriorityIDs(List<String> createdPriorityIDs) {
		this.createdPriorityIDs = createdPriorityIDs;
	}
	public List<String> getCreatedStates() {
		return createdStates;
	}
	public void setCreatedStates(List<String> createdStates) {
		this.createdStates = createdStates;
	}
	public List<String> getCreatedStateIDs() {
		return createdStateIDs;
	}
	public void setCreatedStateIDs(List<String> createdStateIDs) {
		this.createdStateIDs = createdStateIDs;
	}
	public List<String> getCreatedQueues() {
		return createdQueues;
	}
	public void setCreatedQueues(List<String> createdQueues) {
		this.createdQueues = createdQueues;
	}
	public List<String> getCreatedQueueIDs() {
		return createdQueueIDs;
	}
	public void setCreatedQueueIDs(List<String> createdQueueIDs) {
		this.createdQueueIDs = createdQueueIDs;
	}
	public TicketFlag getTicketflag() {
		return ticketflag;
	}
	public void setTicketflag(TicketFlag ticketflag) {
		this.ticketflag = ticketflag;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
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
	public String getFullTextIndex() {
		return fullTextIndex;
	}
	public void setFullTextIndex(String fullTextIndex) {
		this.fullTextIndex = fullTextIndex;
	}
	public String getContentSearch() {
		return contentSearch;
	}
	public void setContentSearch(String contentSearch) {
		this.contentSearch = contentSearch;
	}
	public String getConditionInline() {
		return conditionInline;
	}
	public void setConditionInline(String conditionInline) {
		this.conditionInline = conditionInline;
	}
	public String getArticleCreateTimeOlderMinutes() {
		return articleCreateTimeOlderMinutes;
	}
	public void setArticleCreateTimeOlderMinutes(
			String articleCreateTimeOlderMinutes) {
		this.articleCreateTimeOlderMinutes = articleCreateTimeOlderMinutes;
	}
	public String getArticleCreateTimeNewerMinutes() {
		return articleCreateTimeNewerMinutes;
	}
	public void setArticleCreateTimeNewerMinutes(
			String articleCreateTimeNewerMinutes) {
		this.articleCreateTimeNewerMinutes = articleCreateTimeNewerMinutes;
	}
	public String getArticleCreateTimeNewerDate() {
		return articleCreateTimeNewerDate;
	}
	public void setArticleCreateTimeNewerDate(String articleCreateTimeNewerDate) {
		this.articleCreateTimeNewerDate = articleCreateTimeNewerDate;
	}
	public String getArticleCreateTimeOlderDate() {
		return articleCreateTimeOlderDate;
	}
	public void setArticleCreateTimeOlderDate(String articleCreateTimeOlderDate) {
		this.articleCreateTimeOlderDate = articleCreateTimeOlderDate;
	}
	public String getTicketCreateTimeOlderMinutes() {
		return ticketCreateTimeOlderMinutes;
	}
	public void setTicketCreateTimeOlderMinutes(String ticketCreateTimeOlderMinutes) {
		this.ticketCreateTimeOlderMinutes = ticketCreateTimeOlderMinutes;
	}
	public String getaTicketCreateTimeNewerMinutes() {
		return aTicketCreateTimeNewerMinutes;
	}
	public void setaTicketCreateTimeNewerMinutes(
			String aTicketCreateTimeNewerMinutes) {
		this.aTicketCreateTimeNewerMinutes = aTicketCreateTimeNewerMinutes;
	}
	public String getTicketCreateTimeNewerDate() {
		return ticketCreateTimeNewerDate;
	}
	public void setTicketCreateTimeNewerDate(String ticketCreateTimeNewerDate) {
		this.ticketCreateTimeNewerDate = ticketCreateTimeNewerDate;
	}
	public String getTicketCreateTimeOlderDate() {
		return ticketCreateTimeOlderDate;
	}
	public void setTicketCreateTimeOlderDate(String ticketCreateTimeOlderDate) {
		this.ticketCreateTimeOlderDate = ticketCreateTimeOlderDate;
	}
	public String getTicketChangeTimeOlderMinutes() {
		return ticketChangeTimeOlderMinutes;
	}
	public void setTicketChangeTimeOlderMinutes(String ticketChangeTimeOlderMinutes) {
		this.ticketChangeTimeOlderMinutes = ticketChangeTimeOlderMinutes;
	}
	public String getTicketChangeTimeNewerMinutes() {
		return ticketChangeTimeNewerMinutes;
	}
	public void setTicketChangeTimeNewerMinutes(String ticketChangeTimeNewerMinutes) {
		this.ticketChangeTimeNewerMinutes = ticketChangeTimeNewerMinutes;
	}
	public String getTicketChangeTimeNewerDate() {
		return ticketChangeTimeNewerDate;
	}
	public void setTicketChangeTimeNewerDate(String ticketChangeTimeNewerDate) {
		this.ticketChangeTimeNewerDate = ticketChangeTimeNewerDate;
	}
	public String getTicketChangeTimeOlderDate() {
		return ticketChangeTimeOlderDate;
	}
	public void setTicketChangeTimeOlderDate(String ticketChangeTimeOlderDate) {
		this.ticketChangeTimeOlderDate = ticketChangeTimeOlderDate;
	}
	public String getTicketCloseTimeOlderMinutes() {
		return ticketCloseTimeOlderMinutes;
	}
	public void setTicketCloseTimeOlderMinutes(String ticketCloseTimeOlderMinutes) {
		this.ticketCloseTimeOlderMinutes = ticketCloseTimeOlderMinutes;
	}
	public String getTicketCloseTimeNewerMinutes() {
		return ticketCloseTimeNewerMinutes;
	}
	public void setTicketCloseTimeNewerMinutes(String ticketCloseTimeNewerMinutes) {
		this.ticketCloseTimeNewerMinutes = ticketCloseTimeNewerMinutes;
	}
	public String getTicketCloseTimeNewerDate() {
		return ticketCloseTimeNewerDate;
	}
	public void setTicketCloseTimeNewerDate(String ticketCloseTimeNewerDate) {
		this.ticketCloseTimeNewerDate = ticketCloseTimeNewerDate;
	}
	public String getTicketCloseTimeOlderDate() {
		return ticketCloseTimeOlderDate;
	}
	public void setTicketCloseTimeOlderDate(String ticketCloseTimeOlderDate) {
		this.ticketCloseTimeOlderDate = ticketCloseTimeOlderDate;
	}
	public String getTicketPendingTimeOlderMinutes() {
		return ticketPendingTimeOlderMinutes;
	}
	public void setTicketPendingTimeOlderMinutes(
			String ticketPendingTimeOlderMinutes) {
		this.ticketPendingTimeOlderMinutes = ticketPendingTimeOlderMinutes;
	}
	public String getTicketPendingTimeNewerMinutes() {
		return ticketPendingTimeNewerMinutes;
	}
	public void setTicketPendingTimeNewerMinutes(
			String ticketPendingTimeNewerMinutes) {
		this.ticketPendingTimeNewerMinutes = ticketPendingTimeNewerMinutes;
	}
	public String getTicketPendingTimeNewerDate() {
		return ticketPendingTimeNewerDate;
	}
	public void setTicketPendingTimeNewerDate(String ticketPendingTimeNewerDate) {
		this.ticketPendingTimeNewerDate = ticketPendingTimeNewerDate;
	}
	public String getTicketPendingTimeOlderDate() {
		return ticketPendingTimeOlderDate;
	}
	public void setTicketPendingTimeOlderDate(String ticketPendingTimeOlderDate) {
		this.ticketPendingTimeOlderDate = ticketPendingTimeOlderDate;
	}
	public String getTicketEscalationTimeOlderMinutes() {
		return ticketEscalationTimeOlderMinutes;
	}
	public void setTicketEscalationTimeOlderMinutes(
			String ticketEscalationTimeOlderMinutes) {
		this.ticketEscalationTimeOlderMinutes = ticketEscalationTimeOlderMinutes;
	}
	public String getTicketEscalationTimeNewerMinutes() {
		return ticketEscalationTimeNewerMinutes;
	}
	public void setTicketEscalationTimeNewerMinutes(
			String ticketEscalationTimeNewerMinutes) {
		this.ticketEscalationTimeNewerMinutes = ticketEscalationTimeNewerMinutes;
	}
	public String getTicketEscalationTimeNewerDate() {
		return ticketEscalationTimeNewerDate;
	}
	public void setTicketEscalationTimeNewerDate(
			String ticketEscalationTimeNewerDate) {
		this.ticketEscalationTimeNewerDate = ticketEscalationTimeNewerDate;
	}
	public String getTicketEscalationTimeOlderDate() {
		return ticketEscalationTimeOlderDate;
	}
	public void setTicketEscalationTimeOlderDate(
			String ticketEscalationTimeOlderDate) {
		this.ticketEscalationTimeOlderDate = ticketEscalationTimeOlderDate;
	}
	public List<String> getArchiveFlags() {
		return archiveFlags;
	}
	public void setArchiveFlags(List<String> archiveFlags) {
		this.archiveFlags = archiveFlags;
	}
	public List<String> getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(List<String> orderBy) {
		this.orderBy = orderBy;
	}
	public List<String> getSortBy() {
		return sortBy;
	}
	public void setSortBy(List<String> sortBy) {
		this.sortBy = sortBy;
	}
	public List<String> getCustomerUserID() {
		return customerUserID;
	}
	public void setCustomerUserID(List<String> customerUserID) {
		this.customerUserID = customerUserID;
	}
	public List<DynamicField> getDynamicField() {
		return dynamicField;
	}
	public void setDynamicField(List<DynamicField> dynamicField) {
		this.dynamicField = dynamicField;
	}
	
	
}
