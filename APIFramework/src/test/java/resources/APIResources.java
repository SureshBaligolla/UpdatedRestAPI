package resources;
//enum is special class in java which has collection of constants or  methods
public enum APIResources {
	
	AddPlaceAPI("/customer/api/customer?"),
	AddPlaceAPI1("/customer/api/customer?"),
	GetCustName("/customer/api/customer?customerName="),
	GetCustemail("/customer/api/customer?email="),
	deletePlaceAPI("/customer/api/customer/"),
	AddCustomer("/customer/api/customer?"+"defaultUser=true&defaultOrg=true"),
	registerOrganisation("/customer/api/organisation/"),
	AddUser("/user/api/users?defaultUser=false"),
	GetUserName("user/api/user?userName="),
	GetUserEmail("user/api/user?email="),
	deleteUserAPI("/user/api/user/"),
	Authentication("/api/registerCustomer");
	
	
	
	
	
	
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
