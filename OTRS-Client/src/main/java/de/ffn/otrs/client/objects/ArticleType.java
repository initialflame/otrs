package de.ffn.otrs.client.objects;

public enum ArticleType {

	NOTE_INTERNAL("note-internal"),
	NORE_EXTERNAL("note-external"),
	WEBREQUEST("webrequest"),
	PHONE("phone"),
	FAX("fax"),
	EMAIL_EXTERNAL("email-external"),
	EMAIL_INTERNAL("email-internal");
	
	String label;

	private ArticleType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
}
