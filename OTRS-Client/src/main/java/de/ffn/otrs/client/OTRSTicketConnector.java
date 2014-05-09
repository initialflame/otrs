package de.ffn.otrs.client;

import java.util.List;

import de.ffn.otrs.client.objects.Article;
import de.ffn.otrs.client.objects.DynamicField;
import de.ffn.otrs.client.objects.SessionCreate;
import de.ffn.otrs.client.objects.Ticket;
import de.ffn.otrs.client.objects.TicketCreateResponse;
import de.ffn.otrs.client.objects.TicketSearch;
import de.ffn.otrs.client.objects.TicketUpdateResponse;

public interface OTRSTicketConnector {

	Ticket getTicket(String ticketId, boolean readArticles, boolean readDynamicFields, boolean readAttachments) throws OTRSException;
	
	List<Ticket> getTicket(List<String> ticketId, boolean readArticles,
			boolean readDynamicFields, boolean readAttachments)
			throws OTRSException;
	
	TicketCreateResponse createTicket(Ticket ticket, Article article, List<DynamicField> dynamicFields) throws OTRSException;
	
	TicketUpdateResponse updateTicket(Ticket ticke, Article article) throws OTRSException;
	
	List<String> searchTickets(TicketSearch search) throws OTRSException;
	
	SessionCreate createSession(SessionCreate session) throws OTRSException;

	
}
