package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Utils {

	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		
		if(req==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		 req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
		
		
	}
	
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream("C:\\suresh\\workspace\\APIFramework\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	
		
		
	}
	
	
	public String getJsonPath(Response response,String key)
	{
		  String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}
	
	
	
	
	public void UserRegistrationSuccessful(String name, String custid, String isTerPolAccepted) {
		RestAssured.baseURI = "https://platform.zikzuk.com/customer/api/organisation/"+custid;
		System.out.println(RestAssured.baseURI);
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("orgName", name);
		requestParams.put("email", isTerPolAccepted);
		request.header("Content-Type", "application/json"); // Add the Json to the body of the request 
		request.body(requestParams.toJSONString());
		Response response =request.post();
		System.out.println("The status received: " + response.statusLine());

	}
	 
}
