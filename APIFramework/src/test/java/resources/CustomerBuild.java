package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddCustomer;
import pojo.AddPlace;
import pojo.Location;

public class CustomerBuild {

	
	
	public AddCustomer addCustomerPayLoad(String name, String email, String isTerPolAccepted)
	{
		AddCustomer p =new AddCustomer();
		p.setcustName(name);
		p.setemail(email);
		p.setisTerPolAccepted(isTerPolAccepted);
		return p;
	}
	
	

	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
}
