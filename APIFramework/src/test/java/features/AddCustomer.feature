@AddCustomer
Feature: Validating Customer API's

  @CreateCustomer @Regression @SomkeTesting
  Scenario Outline: Verify if Customer is being Succesfully added using PostAPI
    Given Add Customer Payload with "<custName>" "<email>" "<isTerPolAccepted>"
    When user calls "AddCustomer" with "POST" http request
    Then the API call got success with status code 200
    And "custName" in response body is "Customer 34"
    And "email" in response body is "customer34@zikzuk.com"
    And "status" in response body is "inactive"

    Examples: 
      | custName    | email                 | isTerPolAccepted |
      | Customer 34 | customer34@zikzuk.com | true             |

  @CustomerByName @Regression @SomkeTesting
  Scenario Outline: Verify Customer by customerName  customerEmail being Succesfully added using GETAPI.
    Given GetCustomer Payload
    When user call "GetCustName" "<CustomerByName>" with "GET" http request
    Then the API call got success with status code 200
    And "custName" in response body is "Customer 34"
    And "email" in response body is "customer34@zikzuk.com"

    Examples: 
      | CustomerByName |
      | Customer 34    |

  @CustomerByEmail @Regression @SomkeTesting
  Scenario Outline: Verify Customer by customerName  customerEmail being Succesfully added using GETAPI.
    Given GetCustomer Payload
    When user call "GetCustemail" "<CustomerByEmail>" with "GET" http request
    Then the API call got success with status code 200
    And "custName" in response body is "Customer 34"
    And "email" in response body is "customer34@zikzuk.com"

    Examples: 
      | CustomerByEmail       |
      | customer34@zikzuk.com |

  @DeleteCustomer @Regression @SomkeTesting
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When user calls the "deletePlaceAPI" with delete http request
    Then the API call got success with status code 200

