package de.ffn.otrs.client;

public enum TicketState {

	
	
	NEW("new"),
	OPEN("open"),
	SUCCESSFULLY_CLOSED("closed successful"),
	UNSUCCESSFULLY_CLOSED("closed unsuccessful"),
	WAIT_FOR_SUCCESS("pending auto close+"),
	WAIT_FOR_UNSUCCESS("pending auto close-"),
	WAIT_FOR_REMIND("pending reminder"),
	REMOVED("removed"),
	MERGED("merged");
	
	String label;

	private TicketState(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
