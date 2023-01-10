@Authentication 
Feature: Validating Register Customer API's 

@Register_Customer @Regression @SomkeTesting 
Scenario: Verify if Register Customer is being Succesfully added using PostAPI 
	Given Add Customer Payload with Authentication 
	When user calls "Authentication" payload with "POST" http request 
	Then the Authentication API call got success with status code 200 
	And fetch the customer id and Organization_id 
	
	
	
#@VerfiyTokenEmail @Regression @SomkeTesting 
#Scenario Outline:
#Verify if Verfiy Token Email is being Succesfully 
#	Given Open Inbox check for Token URL 
#	When user calls Token URL enter "<FirstName>" "<MiddleName>" "<LastName>" "<SetPassword>" "<ConfirmPassword>" 
#	Then Cick On submit button 
#	And Verify Password is created 
#	
#	Examples: 
#		| FirstName    | MiddleName | LastName | SetPassword  | ConfirmPassword  |
#		| Customer 51 | customer512 | true     | Welcome@123  | Welcome@123 |
#		
 