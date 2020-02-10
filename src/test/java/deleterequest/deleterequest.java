package deleterequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// Get request json file

public class deleterequest {
	
	
	@Test
	public void Registrationsuccessful() {
		
		//Step1: Create a variable empid and specify the value to be deleted.
		int empid = 15410;
		 
		//Step2: Specify a Request pointing to the Service Endpoint.
		 RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		 RequestSpecification request = RestAssured.given(); 
		 
		 //Step3: Send the Delete Request as described below.
		 // Add a header stating the Request body is a JSON
		 request.header("Content-Type", "application/json"); 
		 
		 // Delete the request and check the response
		 Response response = request.delete("/delete/"+ empid); 
		 
		 //Step4: Validate the PUT Request response received.
		 int statusCode = response.getStatusCode();
		 System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 200);
		 
		 String jsonString =response.asString();
		 Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
		
		
		
	}
	
		
		
		

}
