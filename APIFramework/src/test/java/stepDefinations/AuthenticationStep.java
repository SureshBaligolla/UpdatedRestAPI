package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.CustomerBuild;
import resources.Utils;

public class AuthenticationStep extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	CustomerBuild data = new CustomerBuild();
	String orgId;
	String email;
	String name;
	String yopmail;
	String isTerPolAccepted;
	WebDriver driver;
	WebDriver driver1;
	String tokenURL;

	@Given("^Add Customer Payload with Authentication$")
	public void add_customer_payload_with_authentication() throws Throwable {

		RestAssured.baseURI = "https://Internal-gateway.zikzuk.com/api/registerCustomer";

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://yopmail.com/en/email-generator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		name = driver.findElement(By.xpath("//*[@id=\"geny\"]/span[1]")).getText();
		yopmail = name + "@yopmail.com";
		isTerPolAccepted = "true";
		System.out.println("Email : " + yopmail);
		System.out.println("Authentication validation started");
		System.out.println(RestAssured.baseURI);
		driver.findElement(By.xpath("//span[text()='Check Inbox']")).click();

	}

	@When("^user calls \"([^\"]*)\" payload with \"([^\"]*)\" http request$")
	public void user_calls_something_payload_with_something_http_request(String resource, String method)
			throws Throwable {

		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("custName", name);
		requestParams.put("email", yopmail);
		requestParams.put("isTerPolAccepted", isTerPolAccepted);
		request.header("Content-Type", "application/json");
		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		response = request.post();
		System.out.println("The status received: " + response.statusLine());
	}

	@Then("^the Authentication API call got success with status code 200$")
	public void the_authentication_api_call_got_success_with_status_code_200() throws Throwable {
		assertEquals(response.getStatusCode(), 200);
	}

	@And("^fetch the customer id and Organization_id$")
	public void fetch_the_customer_id_and_organizationid() throws Throwable {
		try {
			email = getJsonPath(response, "email");
			//orgId = getJsonPath(response, "orgId");
			//System.out.println(custId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("Open Inbox check for Token URL")
	public void open_Inbox_check_for_Token_URL() throws Exception {
		System.out.println("OPen inbox");
		// Write code here that turns the phrase above into concrete actions
		//driver.findElement(By.xpath("//span[text()='Check Inbox']")).click();
		WebDriverManager.chromedriver().setup();
	    driver1 = new ChromeDriver();
		driver1.get("https://yopmail.com/en/wm");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.manage().window().maximize();
		driver1.findElement(By.xpath("//input[@id='login']")).sendKeys("brewolleullaxo-9648@yopmail.com");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		tokenURL = driver.findElement(By.id("mail")).getText();
		
		
				
		
		System.out.println(tokenURL);
		
		
		/*
		 * WebElement locOfOrder = driver.findElement(By.id("mail")); Actions act = new
		 * Actions(driver);
		 * act.moveToElement(locOfOrder).doubleClick().build().perform(); // catch here
		 * is double click on the text will by default select the text // now apply copy
		 * command
		 * 
		 * driver.findElement(By.id("mail")).sendKeys(Keys.chord(Keys.CONTROL,"c")); //
		 * now apply the command to paste driver.get(Keys.chord(Keys.CONTROL, "v"));
		 * //driver.findElement (By.xpath(
		 * "/html/body/main/div/div/div[2]/div/div/div[2]/div/table/tbody/tr[2]/td[2]"))
		 * .sendKeys(Keys.chord(Keys.CONTROL, "v"));
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
		
		
		
		
		
		
		
		
	}

	@When("user calls Token URL enter {string} {string} {string} {string} {string}")
	public void user_calls_Token_URL_enter(String firstname, String middlename, String lastname, String setpassword,
			String confirmpassword) {
		// Write code here that turns the phrase above into concrete actions
		driver1.get(tokenURL);
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys(firstname);
		driver1.findElement(By.xpath("//input[@name=\"middleName\"]")).sendKeys(middlename);
		driver1.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys(lastname);
		driver1.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(setpassword);
		driver1.findElement(By.xpath("//input[@id=\"password6\"]")).sendKeys(confirmpassword);
	}

	@Then("Cick On submit button")
	public void cick_On_submit_button() {

		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//button[text()='Submit']")).click();

	}

	@Then("Verify Password is created")
	public void verify_Password_is_created() {
		System.out.println();
	}

}
