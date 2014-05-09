package de.ffn.otrs.client;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class MYNamespacePrefixMapper extends NamespacePrefixMapper {

	
	
	public MYNamespacePrefixMapper() {
		super();
	}

	@Override
	public String getPreferredPrefix(String arg0, String arg1, boolean arg2) {
		if("http://www.otrs.org/TicketConnector/".equalsIgnoreCase(arg0)){
			return "otrs";
		}
		return null;
	}
	
}