package getrequest;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

// Get request json file

public class getrequest {
	
	String baseURI;
	
	
	@Test
	public void getweatherDetails() {
		
		//Specify base URI
		
		baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Create the request object
		RequestSpecification httprequest=given();
		
		//Create a response object
		Response response=httprequest.request(Method.GET,"/hyderabad");//pass the request type and the parameter
		
		//Print response in console window
		
		String responsebody=response.getBody().asString();
		System.out.println("Response body isresponsebody is: " + responsebody);
		
		//Status code validation
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
		//Status line validation
		String statusline=response.getStatusLine();
		System.out.println(statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
		
	}
	
		
		
		

}
