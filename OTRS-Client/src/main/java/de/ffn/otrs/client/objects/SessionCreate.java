package de.ffn.otrs.client.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *       <SessionCreate>
         <!--You have a MANDATORY CHOICE of the next 2 items at this level-->
         <!--Optional:-->
         <UserLogin>?</UserLogin>
         <!--Optional:-->
         <CustomerUserLogin>?</CustomerUserLogin>
         <!--Optional:-->
         <Password>?</Password>
      </SessionCreate>
 * @author sk0007
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="SessionCreate")
public class SessionCreate implements OTRSRequest {
	
	@XmlElement(name="UserLogin")
	private String userLogin;
	
	@XmlElement(name="CustomerUserLogin")
	private String customerUserLogin;
	
	@XmlElement(name="Password")
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSessionID(String sessionID) {
		throw new RuntimeException("Not implemented");
	}
	
	
}
