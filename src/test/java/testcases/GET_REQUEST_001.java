package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Test
public class GET_REQUEST_001 {

	
	
 public void get_user_details() {
		
		  //Specify base URI
		  RestAssured.baseURI="https://fakerestapi.azurewebsites.net/api/v1/Users";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Response object
		  Response response=httpRequest.request(Method.GET);
		  
		  //print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		  Assert.assertEquals(statusCode, 200);
		  
		  //status line verification
		  String statusLine=response.getStatusLine();
		  System.out.println("Status line is:"+statusLine);
		  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		  
		 }
		
	
	
}
