package jira;

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
import io.restassured.specification.RequestSpecification;

public class Deleteissue {
	@Test
	public void delteIssue() {
		RestAssured.baseURI = "https://vivekraj.atlassian.net/rest/api/2/issue/10021";
		RestAssured.authentication = RestAssured.preemptive().basic("vivek.rajendran85@gmail.com", "B2MHiBR1ZGOeO7GlHHcrBF1A");
		
		//File data = new File("./dataisse.json");
		
		Response response = RestAssured
				.given()
				.header("Content-Type","application/json")
				.log().all()
				.delete();
		
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		if(statusCode == 204)
			System.out.println("Issue has been deleted successfully");
		else 
			System.out.println("Issue is not deleted");
		
		
		/*JsonPath jsonPath = response.jsonPath();
		
		jsonPath.prettyPrint();
		 String id = jsonPath.get("result.id");
		 System.out.println(id);*/
		
		
	}

}
