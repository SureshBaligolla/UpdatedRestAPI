package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import io.cucumber.java.en.And;
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
	static String UserID;

	@Given("the customer is allowed to sync with customer ID {string} {string} {string} {string}\"")
	public void the_customer_is_allowed_to_sync_with_customer_ID(String UserName, String email, String customerId,
			String orgId) throws Exception {

		System.out.println("Testing OrganisationBuild");
		res = given().spec(requestSpecification()).body(user.AddUserPayLoad(UserName, email, customerId, orgId));
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
			response = res.when().get(resourceAPI.getResource());

		System.out.println(response.asString());

	}

	@Then("the API User call got success with a status code {int}")
	public void the_API_User_call_got_success_with_a_status_code(Integer int1) {

		assertEquals(response.getStatusCode(), 200);
		try {
			UserID = getJsonPath(response, "userId");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	@Given("^GetUser Payload$")
	public void getuser_payload() throws Throwable {
		System.out.println("Checking Payload ......");
		res = given().spec(requestSpecification());
		System.out.println(res.toString());
	}

	@When("^user call \"([^\"]*)\" \"([^\"]*)\" with \"([^\"]*)\" http request user$")
	public void user_call_something_something_with_something_http_request_user(String resource, String Quer,
			String method) throws Throwable {
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource() + Quer);
		if (method.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().get(resourceAPI.getResource() + Quer);

		System.out.println(response.asString());
	}

	@And("^\"([^\"]*)\" in response body is \"([^\"]*)\" user$")
	public void something_in_response_body_is_something_user(String keyValue, String Expectedvalue) throws Throwable {
		String actualName1 = getJsonPath(response, keyValue);
		System.out.println(Expectedvalue + "=" + actualName1);
		try {
			UserID = getJsonPath(response, "userId");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(UserID);
	}
	
	
	@Given("User Delete Place Payload")
	public void User_Delete_Place_Payload() throws IOException {

		System.out.println("Checking Payload ......");
		res = given().spec(requestSpecification());
		System.out.println(res.toString());

	}

	@When("User calls the {string} with delete http request")
	public void User_calls_the_with_delete_http_request(String resource) throws Exception {
		// Write code here that turns the phrase above into concrete actions

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		response = res.when().delete(resourceAPI.getResource() + UserID);
		System.out.println(response.asString());

	}
	
	
	
	
	
	
	
	
	
	
	

}