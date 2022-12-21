@CreateUser 
Feature: Validating User API's 

@AddUser @Regression @SomkeTesting 
Scenario Outline: 
	Verify if Customer is being add User Succesfully added using PostAPI 
	
	Given the customer is allowed to sync with customer ID "<userName>" "<email>" "<customerId>" "<orgId>" 
	When the user calls "AddUser" with "POST" http request new company User is created 
	Then the API User call got success with a status code 200 
	
	
	Examples: 
		| userName | email             | customerId                         |orgId                                |
		| userpro1 | userpro1@zikzuk.com |43b1e78d-63a2-468f-9f5d-cc5de7d7083d|7a8641dc-1bd4-481b-8089-5b8d574ce21a"|
		
		
		
		@UserByName @Regression @SomkeTesting 
		Scenario Outline:
		Verify Customer by customerName  customerEmail being Succesfully added using GETAPI. 
			Given GetUser Payload 
			When user call "GetUserName" "<GetUSerByName>" with "GET" http request user 
			Then the API User call got success with a status code 200 
			And "userName" in response body is "userpro1" user 
			And "email" in response body is "userpro1@zikzuk.com" user 
			
			
			Examples: 
				| GetUSerByName |
				| userpro1     |
				
				@UserByEmail @Regression @SomkeTesting 
				Scenario Outline:
				Verify Customer by customerName  customerEmail being Succesfully added using GETAPI. 
					Given GetUser Payload 
					When user call "GetUserEmail" "<UserByEmail>" with "GET" http request user 
					Then the API User call got success with a status code 200 
					And "userName" in response body is "userpro1" user 
					And "email" in response body is "userpro1@zikzuk.com" user 
					
					Examples: 
						| UserByEmail       |
						| userpro1@zikzuk.com |
						
						
						
						@DeleteUser @Regression @SomkeTesting 
						Scenario: Verify if Delete Place functionality is working 
							Given User Delete Place Payload 
							When User calls the "deleteUserAPI" with delete http request 
							Then the API User call got success with a status code 200 
							
