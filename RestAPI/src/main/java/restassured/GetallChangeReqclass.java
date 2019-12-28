package restassured;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetallChangeReqclass {
	@Test
	public void getAll() {
		RestAssured.baseURI = "https://dev77917.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "oUJ5YskOJo4a");
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("category", "Network");
		parametersMap.put("State", "-5");
		Response response = RestAssured
				.given()
				.header("Accept","application/xml")
				.params(parametersMap)
				.get();
		
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		if(statusCode == 200)
			System.out.println("Response is pass");
		else 
			System.out.println("Response is bad");
		
		
		XmlPath responsexml = response.xmlPath();
		
		responsexml.prettyPrint();
		List<String> AllChngReq = responsexml.getList("response.result.number");
		
		System.out.println("List size for incidentnumber :"+ AllChngReq.size());
		for (String eachchag : AllChngReq) {
			System.out.println(eachchag);
			
		}
		
		
		
		
	}

}
