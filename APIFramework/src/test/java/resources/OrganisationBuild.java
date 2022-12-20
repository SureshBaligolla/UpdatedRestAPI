package resources;

import pojo.AddOrganisation;

public class OrganisationBuild {

	
	
	public AddOrganisation AddOrganisationPayLoad(String name, String email)
	{
		AddOrganisation p =new AddOrganisation();
		p.setorgName(name);
		p.setemail(email);
		return p;
	}
	
	
}
