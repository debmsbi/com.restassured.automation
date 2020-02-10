package postrequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// Get request json file

public class postrequest {
	
	
	@Test
	public void Registrationsuccessful() {
		
		//Specify base URI
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Create the request object
		RequestSpecification httprequest=RestAssured.given();
		
		//Request Payload sending along with Post request
		JSONObject requestparams=new JSONObject();
		
		requestparams.put("FirstName", "Debashish");
		requestparams.put("LastName", "Chakraborty");
		requestparams.put("UserName", "debchak035");
		requestparams.put("Password", "Hanuman");
		requestparams.put("Email", "debchak035@gmail.com");
		
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestparams.toJSONString());  //attach data to the request
		
		//Create a response object
		Response response=httprequest.request(Method.POST,"/register");//pass the request type and the parameter
		
		//Print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response body isresponsebody is: " + responsebody);
		
		//Status code validation
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 201);
				
		//Success code validation
		String successcode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successcode, "OPERATION_SUCCESS");
		
		
		
	}
	
		
		
		

}
