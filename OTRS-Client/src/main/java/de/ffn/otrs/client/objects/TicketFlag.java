package de.ffn.otrs.client.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * <Ticketflag>
            <!--Optional:-->
            <Seen>?</Seen>
         </Ticketflag>
 * 
 * @author sk0007
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TicketFlag")
public class TicketFlag {

	@XmlElement(name="Seen" )
	private String seen;

	public String getSeen() {
		return seen;
	}

	public void setSeen(String seen) {
		this.seen = seen;
	}
	
}
