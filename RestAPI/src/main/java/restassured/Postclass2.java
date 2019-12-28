package restassured;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Postclass2 {
	@Test
	public void getAll() {
		RestAssured.baseURI = "https://dev77917.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "oUJ5YskOJo4a");
		
		File data = new File("./data.json");
		
		Response response = RestAssured
				.given()
				.header("Content-Type","application/json")
				.log().all()
				.body(data)
				.post();
		
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		if(statusCode == 201)
			System.out.println("Response is pass");
		else 
			System.out.println("Response is bad");
		
		
		JsonPath jsonPath = response.jsonPath();
		
		jsonPath.prettyPrint();
		 String number = jsonPath.get("result.number");
		 System.out.println(number);
		
		
	}

}
