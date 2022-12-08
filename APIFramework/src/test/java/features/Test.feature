#@AddCustomer
#Feature: Validating Customer API's

  #@CreateCustomer @Regression @SomkeTesting
  #Scenario Outline: Verify if Customer is being Succesfully added using PostAPI
  #Given Add Customer Payload with "<custName>" "<email>" "<isTerPolAccepted>"
  #When user calls "AddCustomer" with "POST" http request
  #Then the API call got success with status code 200
  #And "custName" in response body is "Customer 26"
  #And "email" in response body is "customer26@zikzuk.com"
  #And "status" in response body is "inactive"
  #
  #Examples:
  #| custName    | email                 | isTerPolAccepted |
  #| Customer 26 | customer26@zikzuk.com | true             |
  #@Createorg
  #Scenario Outline: Verify if Customer is being Succesfully added using PostAPI
    #Given Add Customer "<custName>" "<email>" "<isTerPolAccepted>"
#
    #Then the API call got success with status code 200
    #Examples: 
      #| custName  | email                                | isTerPolAccepted      |
      #| UserOrg2  | bac87041-f1a8-40d6-a6ec-abb49c946cdd | UserOrg2@yopmail.com  |
      #| UserOrg3  | f056954e-3ffc-4a89-a9ce-92199209fb4c | UserOrg3@yopmail.com  |
      #| UserOrg4  | f4311204-f349-4a36-b0af-74cfd5e00ae4 | UserOrg4@yopmail.com  |
      #| UserOrg5  | 2e0acf5b-9d1e-40d7-8b12-580766e48f35 | UserOrg5@yopmail.com  |
      #| UserOrg6  | 99f43c44-4476-42ef-8cdc-f7b35bd67950 | UserOrg6@yopmail.com  |
      #| UserOrg7  | 8e2c5c93-906c-4f2c-a235-37f064281acc | UserOrg7@yopmail.com  |
      #| UserOrg8  | dddaa761-3a9b-4b04-ae42-a2537cf8ed1e | UserOrg8@yopmail.com  |
      #| UserOrg9  | 84cad00c-5390-4acd-ae88-2b1500057949 | UserOrg9@yopmail.com  |
      #| UserOrg10 | 0892c69e-f465-41cf-a11d-4aeac3cd9896 | UserOrg10@yopmail.com |
      #| UserOrg11 | 70fabde5-7579-4276-9796-baae3735ec17 | UserOrg11@yopmail.com |
      #| UserOrg12 | 909f0dcf-ac5c-414d-a467-82fe5f0c3f86 | UserOrg12@yopmail.com |
      #| UserOrg13 | 38c0b0a8-cd71-4e46-b3cd-a018dd7db6cf | UserOrg13@yopmail.com |
      #| UserOrg14 | 4264df8e-3469-48c3-8a91-63d81fc16132 | UserOrg14@yopmail.com |
      #| UserOrg15 | 24ed2495-4e8d-4fa8-9ca1-4c62040b07a3 | UserOrg15@yopmail.com |
      #| UserOrg16 | cace38c4-20d2-4d92-be1d-4e4bf5234077 | UserOrg16@yopmail.com |
      #| UserOrg17 | ef2003fb-4153-4d12-8345-474f7a6b8710 | UserOrg17@yopmail.com |
      #| UserOrg18 | ba241e85-bb55-4e9d-9cc6-2f3ad20e0551 | UserOrg18@yopmail.com |
      #| UserOrg19 | 45969bcf-40d8-4a61-b5a8-e7aafcde4347 | UserOrg19@yopmail.com |
      #| UserOrg20 | 57029469-8a35-46c3-bc16-76ee07ef2b25 | UserOrg20@yopmail.com |
      #| UserOrg21 | 75be811d-05bb-4f88-93ec-86bee453e6ec | UserOrg21@yopmail.com |
      #| UserOrg22 | 55620f56-6903-4a67-a8e7-5cd4230036ac | UserOrg22@yopmail.com |
      #| UserOrg23 | e039e8c9-d153-4c73-a96e-cadcf2037936 | UserOrg23@yopmail.com |
      #| UserOrg24 | 7a68adbb-e937-46fc-a9a1-2b1153d31d8e | UserOrg24@yopmail.com |
      #| UserOrg25 | 6e03c954-f842-49b7-a9c0-171a835fc958 | UserOrg25@yopmail.com |
      #| UserOrg26 | 7a4952ec-8ed1-4e02-8b89-07dca072537a | UserOrg26@yopmail.com |
      #| UserOrg27 | 79e4b623-5d19-4a58-a615-cb3008d9f2ad | UserOrg27@yopmail.com |
      #| UserOrg28 | f8baf379-9cfa-4899-848b-accbb9fe328d | UserOrg28@yopmail.com |
      #| UserOrg29 | 3078d20d-941b-45fd-97b3-643b19963fab | UserOrg29@yopmail.com |
      #| UserOrg30 | 502505d4-f7a7-4ad6-8f65-7d4aa601eba6 | UserOrg30@yopmail.com |
      #| UserOrg31 | ff704f12-7bf6-4375-92de-8f2d2ba6fc70 | UserOrg31@yopmail.com |
      #| UserOrg32 | a08c794c-8de2-4380-8e3c-3fbd1a6757c6 | UserOrg32@yopmail.com |
      #| UserOrg33 | a910b72b-5143-4565-a510-9bf1473c653d | UserOrg33@yopmail.com |
      #| UserOrg34 | 2d917347-c96f-4b86-b452-47863d9e35ad | UserOrg34@yopmail.com |
      #| UserOrg35 | f688ad8e-b312-4340-b4ae-1a2f97fbfcad | UserOrg35@yopmail.com |
      #| UserOrg36 | e02b0e5d-3f28-480c-b321-93103c9f1bfa | UserOrg36@yopmail.com |
      #| UserOrg37 | daea8a5e-1ca1-4e82-a14c-28da2aef75e5 | UserOrg37@yopmail.com |
      #| UserOrg38 | e398780e-3667-433d-a06d-11c90cd24d7f | UserOrg38@yopmail.com |
      #| UserOrg39 | 97d18f1d-c202-4b4f-b2a7-adaa6bdc8fc9 | UserOrg39@yopmail.com |
      #| UserOrg40 | 5347fb71-61dd-4ab9-bc28-ffd10d3e2052 | UserOrg40@yopmail.com |
      #| UserOrg41 | 8841a38c-b401-4149-810c-50ec03215ee7 | UserOrg41@yopmail.com |
      #| UserOrg42 | 690297c2-2004-419b-a6d1-5cea9f0ea9ae | UserOrg42@yopmail.com |
      #| UserOrg43 | 075be1f8-cf48-4b98-a435-15668925fbe6 | UserOrg43@yopmail.com |
      #| UserOrg44 | 83836d9a-5b0d-41a6-afb3-13e048ce056f | UserOrg44@yopmail.com |
      #| UserOrg45 | bb9334df-db5f-4ad8-b1ef-4dcbbc036390 | UserOrg45@yopmail.com |
      #| UserOrg46 | 34d8e229-8775-49cf-a9b9-35893f5be08b | UserOrg46@yopmail.com |
      #| UserOrg47 | 76fa8281-b0e2-4934-a66b-0d67df36f0da | UserOrg47@yopmail.com |
      #| UserOrg48 | df359a17-7090-41f5-b801-8adb6ef4f28c | UserOrg48@yopmail.com |
      #| UserOrg49 | fe733328-910a-40e4-a07f-35a354fb5ea1 | UserOrg49@yopmail.com |
#
  #@CustomerByName
  #Scenario Outline: Verify Customer by customerName  customerEmail being Succesfully added using GETAPI.
    #Given GetCustomer Payload
    #When user call "GetCustName" "<CustomerByName>" with "GET" http request
    #Then the API call got success with status code 200
    #And "custId" in response body is "<CustomerByName>"
#
    #And "email" in response body is "customer25@zikzuk.com"
    #Examples: 
      #| CustomerByName | isss | fdgdfg |
  #@CustomerByName @Regression @SomkeTesting
  #Scenario Outline: Verify Customer by customerName  customerEmail being Succesfully added using GETAPI.
    #Given GetCustomer Payload
    #When user call "GetCustName" "<CustomerByName>" with "GET" http request
    #Then the API call got success with status code 200
    #And "custName" in response body is "Customer 25"
    #And "email" in response body is "customer25@zikzuk.com"
#
    #Examples: 
      #| CustomerByName |
      #| Customer 25    |
#
  #@CustomerByEmail @Regression @SomkeTesting
  #Scenario Outline: Verify Customer by customerName  customerEmail being Succesfully added using GETAPI.
    #Given GetCustomer Payload
    #When user calls "<CustomerByEmail>" with "GET" http request
    #Then the API call got success with status code 200
    #And "custName" in response body is "Customer 20"
    #And "email" in response body is "customer20@zikzuk.com"
#
    #Examples: 
      #| CustomerByEmail       |
      #| customer20@zikzuk.com |
#
#
  #@DeletePlace @Regression @SomkeTesting
  #Scenario: Verify if Delete Place functionality is working
    #Given DeletePlace Payload
    #When user calls "deletePlaceAPI" with "POST" http request
    #Then the API call got success with status code 200
    #And "status" in response body is "OK"
