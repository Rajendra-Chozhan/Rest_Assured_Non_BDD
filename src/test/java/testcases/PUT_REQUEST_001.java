package testcases;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PUT_REQUEST_001 {
	
	@Test
	public void put() {

		 //Specify base URI
		  RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Response object
		 
		 JSONObject requestParams = new JSONObject(); 
		 requestParams.put("title","Raj");
		 requestParams.put("body","4000");
		 requestParams.put("userId","29");
		 requestParams.put("id","29");
		 		  
		  httpRequest.header("contentType","application/json");
		  httpRequest.body(requestParams.toJSONString());
		 // httpRequest.body(jsonString);
		  	  
		  
		  //Response object
		  
		  Response response = httpRequest.request(Method.PUT,"/posts/1");
		  
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
