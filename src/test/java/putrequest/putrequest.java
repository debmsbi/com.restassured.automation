package putrequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// Get request json file

public class putrequest {
	
	
	@Test
	public void Registrationsuccessful() {
		
		//Step 1: Create a variable empid which we intend to update with our PUT request.
		int empid = 15410;
		 
		//Step 2: Create a Request pointing to the Service Endpoint
		 RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		 RequestSpecification request = RestAssured.given();
		 
		 //Step 3: Create a JSON request which contains all the fields which we wish to update.
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "Zion"); // Cast
		 requestParams.put("age", 23);
		 requestParams.put("salary", 12000);
		 
		 //Step 4. Send JSON content in the body of Request and pass PUT Request
		 request.body(requestParams.toJSONString());
		 Response response = request.put("/update/"+ empid);
		 
		 //Step 5: Validate the PUT Request response received
		 int statusCode = response.getStatusCode();
		 System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 200); 
		
		
		
	}
	
		
		
		

}
