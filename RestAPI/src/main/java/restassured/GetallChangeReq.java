package restassured;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetallChangeReq {
	@Test
	public void getAll() {
		RestAssured.baseURI = "https://dev77917.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "oUJ5YskOJo4a");
		Response response = RestAssured.get();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		if(statusCode == 200)
			System.out.println("Response is pass");
		else 
			System.out.println("Response is bad");
		
		JsonPath responsejson = response.jsonPath();
		List<String> AllIncident = responsejson.getList("result.number");
		System.out.println("List size for incidentnumber :"+ AllIncident.size());
		for (String eachincident : AllIncident) {
			System.out.println(eachincident);
			
		}
		
		List<String> Allsysid = responsejson.getList("result.sys_id");
		System.out.println("List size for sysid :"+ Allsysid.size());
		
		for (String eachsysid : Allsysid) {
			System.out.println(eachsysid);
			
		}
	}

}
