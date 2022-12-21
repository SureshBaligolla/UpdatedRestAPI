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
import resources.Utils;

public class OrganisationStep extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	OrganisationBuild Org = new OrganisationBuild();
	static String custId;

	@Given("the customer is allowed to sync with customer ID {string} {string}")
	public void the_customer_is_allowed_to_sync_with_customer_ID(String orgName, String email) throws Exception {

		System.out.println("Testing OrganisationBuild");
		res = given().spec(requestSpecification()).body(Org.AddOrganisationPayLoad(orgName, email));
		System.out.println(res);
	}


	@When("the user calls {string} with {string} http request new company Organisation is created")
	public void the_user_calls_with_http_request_new_company_Organisation_is_created(String resource, String method) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource()+"43b1e78d-63a2-468f-9f5d-cc5de7d7083d");
		else if (method.equalsIgnoreCase("GET"))
			response = res.when()
			
					.get(resourceAPI.getResource() + "43b1e78d-63a2-468f-9f5d-cc5de7d7083d" + "?orgName=Orgname 44");

		System.out.println(response.asString());
	}

	@Then("the API Organisation call got success with status code {int}")
	public void the_API_Organisation_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions

		if (int1.equals(200)) {
			assertEquals(response.getStatusCode(), 200);
		} else {
			assertEquals(response.getStatusCode(), 400);
		}

	}

	@Given("GetOrganisation Payload")
	public void getOrganisation_Payload() throws IOException {

		System.out.println("Checking Payload ......");
		res = given().spec(requestSpecification());
		System.out.println(res.toString());
	}

	@Then("{string} in response body is {string} Organisation api")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
		// Write code here that turns the phrase above into concrete actions

		System.out.println(keyValue+Expectedvalue);
		String actualName1 = getJsonPath(response, keyValue);

		
		System.out.println(Expectedvalue + "=" + actualName1);
		//custId = getJsonPath(response, "custId");
		

	}

}