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
import resources.TestDataBuild;
import resources.Utils;

public class AddCustomerStep extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	CustomerBuild data = new CustomerBuild();
	static String custName;
	static String custId;

	@Given("Add Customer Payload with {string} {string} {string}")
	public void add_Customer_Payload_with(String name, String email, String isTerPolAccepted) throws IOException {
		System.out.println("Test");
		res = given().spec(requestSpecification()).body(data.addCustomerPayLoad(name, email, isTerPolAccepted));
		System.out.println(res);

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions
		// constructor will be called with value of resource which you pass
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().get(resourceAPI.getResource());

		System.out.println(response.asString());

	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
		// Write code here that turns the phrase above into concrete actions

		String actualName1 = getJsonPath(response, keyValue);
		System.out.println(Expectedvalue + "=" + actualName1);
		custId = getJsonPath(response, "custId");

	}

	@Given("GetCustomer Payload")
	public void getcustomer_Payload() throws IOException {

		System.out.println("Checking Payload ......");
		res = given().spec(requestSpecification());
		System.out.println(res.toString());
	}

	@When("user call {string} {string} with {string} http request")
	public void user_call_with_http_request(String resource, String Quer, String method) {
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource() + Quer);
		if (method.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().get(resourceAPI.getResource() + Quer);

		System.out.println(response.asString());
	}

	@Given("^Add Customer \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_customer_something_something_something(String custname, String id, String isterpolaccepted)
			throws Throwable {

		UserRegistrationSuccessful(custname, id, isterpolaccepted);

	}

	@Given("DeletePlace Payload")
	public void deleteplace_Payload() throws IOException {

		System.out.println("Checking Payload ......");
		res = given().spec(requestSpecification());
		System.out.println(res.toString());

	}

	@When("user calls the {string} with delete http request")
	public void user_calls_the_with_delete_http_request(String resource) {
		// Write code here that turns the phrase above into concrete actions

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		response = res.when().delete(resourceAPI.getResource() + custId);
		System.out.println(response.asString());

	}
}