@CreateUser 
Feature: Validating User API's 

@AddUser 
Scenario Outline: 
	Verify if Customer is being add User Succesfully added using PostAPI 
	
	Given the customer is allowed to sync with customer ID "<orgName>" "<email>" "<customerId>" "<orgId>" 
	When the user calls "AddUser" with "POST" http request new company User is created 
	Then the API User call got success with status code 200 
	
	
	Examples: 
		| orgName | email             | customerId                         |orgId                                |
		| User 50 | User50@zikzuk.com |43b1e78d-63a2-468f-9f5d-cc5de7d7083d|7a8641dc-1bd4-481b-8089-5b8d574ce21a"|
		