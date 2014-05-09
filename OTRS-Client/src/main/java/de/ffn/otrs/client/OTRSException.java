package de.ffn.otrs.client;

import de.ffn.otrs.client.objects.OTRSResponse;

public class OTRSException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7907912814245975518L;
	private OTRSResponse response;

	public OTRSException(String message, Throwable cause) {
		super(message, cause);
	}

	public OTRSException(String message) {
		super(message);
	}

	public OTRSException(Throwable cause) {
		super(cause);
	}

	public OTRSException(String message, OTRSResponse response) {
		this.response = response;
	}

	@Override
	public String getMessage() {
		if(response != null
				&& response.getError() != null)
			return response.getError().toString();
		return super.getMessage();
	}

	
	
}
