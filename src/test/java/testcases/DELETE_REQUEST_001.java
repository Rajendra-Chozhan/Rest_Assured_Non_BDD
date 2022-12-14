package testcases;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETE_REQUEST_001 {

	@Test
	public void delete_request() {
		
		//Specify base URI
		   RestAssured.baseURI="https://reqres.in/api/users?page=2";
		              
		   //Request object
		   RequestSpecification httpRequest=RestAssured.given();
		              
		  
		   //print response in console window//Request payload sending along with post request
		 JSONObject requestParams=new JSONObject();
		              
		  requestParams.put("id",14);
		                          
		   httpRequest.header("Content-Type","application/json");
		              
		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		               
		   //Response object
		   Response response=httpRequest.request(Method.DELETE);
		              
		   String responseBody=response.getBody().asString();
		   System.out.println("Response Body is:" +responseBody);
		              
		  //status code validation
		   int statusCode=response.getStatusCode();
		   System.out.println("Status code is: "+statusCode);
		   Assert.assertEquals(statusCode, 204);         
		  }
}
