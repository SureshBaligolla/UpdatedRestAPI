package resources;

import pojo.AddUser;

public class UserBuild {

	
	
	public AddUser AddUserPayLoad(String UserName, String email, String customerId, String orgId)
	{
		AddUser p =new AddUser();
	    p.setUserName(UserName);
	    p.setEmail(email);
	    p.setCustomerId(customerId);
	    p.setOrgId(orgId);
		return p;
	}
	
	
}
