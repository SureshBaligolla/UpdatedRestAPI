@CreateOrganisation 
Feature: Validating Organisation API's 

@Organisation 
Scenario: Verify if Customer is being Succesfully added using PostAPI 
	Given the customer is allowed to sync with us 
	When the New company sync success 
	Then the Organisation is created
	And Org_id is createdin the Org collection
	And Customer_id is added to the Org collection
	
