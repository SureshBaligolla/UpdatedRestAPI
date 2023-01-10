@CreateOrganisation 
Feature: Validating Organisation API's 

@AddOrganisation 
Scenario Outline: 
	Verify if Customer is being add Organisation Succesfully added using PostAPI 
	
	Given the customer is allowed to sync with customer ID "<orgName>" "<email>" 
	When the user calls "registerOrganisation" with "POST" http request new company Organisation is created 
	Then the API Organisation call got success with status code 200 
	
	
	Examples: 
		| orgName     | email              |
		| Orguser66 | Orguser66@zikzuk.com |
		
		
		
		@OrganisationByName @Regression @SomkeTesting
		Scenario:
		Verify Customer by customerName  customerEmail being Succesfully added using GETAPI. 
			Given GetOrganisation Payload 
			When the user calls "registerOrganisation" with "GET" http request new company Organisation is created 
			Then the API Organisation call got success with status code 200 
			And "orgName" in response body is "Orguser66" Organisation api 
			And "email" in response body is "Orguser66@zikzuk.com" Organisation api 
			
			
			
      