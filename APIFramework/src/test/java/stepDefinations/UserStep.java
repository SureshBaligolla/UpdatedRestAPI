package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.CustomerBuild;
import resources.OrganisationBuild;
import resources.TestDataBuild;
import resources.UserBuild;
import resources.Utils;

public class UserStep extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	UserBuild user = new UserBuild();
	static String custId;


	
	@Given("the customer is allowed to sync with customer ID {string} {string} {string} {string}\"")
	public void the_customer_is_allowed_to_sync_with_customer_ID(String UserName, String email, String customerId, String orgId) throws Exception {
	
		System.out.println("Testing OrganisationBuild");
		res = given().spec(requestSpecification()).body(user.AddUserPayLoad(UserName, email,customerId,orgId));
		System.out.println(res);
	}


	@When("the user calls {string} with {string} http request new company User is created")
	public void the_user_calls_with_http_request_new_company_User_is_created(String resource, String method) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

				if (method.equalsIgnoreCase("POST"))
						response = res.when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = res.when()
					.get(resourceAPI.getResource());

		System.out.println(response.asString());
		
		
	}

	@Then("the API User call got success with status code {int}")
	public void the_API_User_call_got_success_with_status_code(Integer int1) {

		if (int1.equals(200)) {
			assertEquals(response.getStatusCode(), 200);
		} else {
			assertEquals(response.getStatusCode(), 400);
		}
		
	}

	
	
	
	
	
	
	
	
	
}