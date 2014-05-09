package de.ffn.otrs.client.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * <Error>
		<ErrorCode>TicketGet.MissingParameter</ErrorCode>
		<ErrorMessage>TicketGet: TicketID parameter is missing!</ErrorMessage>
	</Error>
 * 
 * @author sk0007
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Error", namespace="http://www.otrs.org/TicketConnector/")
public class Error {

	@XmlElement(name="ErrorCode")
	private String errorCode;
	
	@XmlElement(name="ErrorMessage")
	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorCode + ": " + errorMessage ;
	}
	
	
	
}
