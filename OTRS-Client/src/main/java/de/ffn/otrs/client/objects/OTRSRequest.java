package de.ffn.otrs.client.objects;

public interface OTRSRequest {

	public void setUserLogin(String userLogin);
	
	public void setPassword(String password);
	
	public void setCustomerUserLogin(String customerUserLogin);
	
	public void setSessionID(String sessionID);
	
}
