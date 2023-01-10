package resources;

import pojo.AuthenticationBuild;

public class AuthenticationBuilds {
	
	
	
	
	public AuthenticationBuild addAuthenticationPayLoad(String name, String email, String isTerPolAccepted)
	{
		AuthenticationBuild pc =new AuthenticationBuild();
		
		
		pc.setcustName(name);
		pc.setemail(email);
		pc.setisTerPolAccepted(isTerPolAccepted);
		return pc;
	}

}
