package jira;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetallIssues {
	@Test
	public void getAllIssues() {
		RestAssured.baseURI = "https://vivekraj.atlassian.net/rest/api/2/search";
		RestAssured.authentication = RestAssured.preemptive().basic("vivek.rajendran85@gmail.com", "B2MHiBR1ZGOeO7GlHHcrBF1A");
		/*Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("category", "Network");
		parametersMap.put("State", "-5");*/
		Response response = RestAssured
				.given()
				.header("Content-Type","application/json")
				.log().all()
				.get();
		
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		if(statusCode == 200)
			System.out.println("Response is pass");
		else 
			System.out.println("Response is bad");
		
		
		//XmlPath responsexml = response.xmlPath();
		JsonPath jsonPath = response.jsonPath();
		//jsonPath.prettyPrint();
		List<String> Allissues = jsonPath.getList("issues.id");
		
		System.out.println("Total no.of Issues :"+ Allissues.size());
		for (String eachissue : Allissues) {
			System.out.println(eachissue);
			
		}
		
		
		
		
	}

}
