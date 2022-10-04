package testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_REQUEST_001 {

	
	
	@Test
 public void post_request() {
		
		  //Specify base URI
		  RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/create";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Response object
		 
		 JSONObject requestParams = new JSONObject(); 
		 requestParams.put("name","Raj");
		 requestParams.put("salary","4000");
		 requestParams.put("age","29");
		 
		 		  
		  httpRequest.header("contentType","application/json");
		  httpRequest.body(requestParams.toJSONString());
		 // httpRequest.body(jsonString);
		  	  
		  
		  //Response object
		  
		  Response response = httpRequest.request(Method.POST);
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		 // Assert.assertEquals(statusCode, 200);
		  
		  //status line verification
		  String statusLine=response.getStatusLine();
		  System.out.println("Status line is:"+statusLine);
		 // Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		  
		 }
	
}
