package api.endPoints;

import api.Payload.userPayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserCrudOperation {
	
	public static Response createUser(userPayload payload)
	{
		Response response=RestAssured.given()
		.baseUri(Routes.BaseUrl)
		.header("Content-Type","application/json")
		.body(payload)
		.log().all()
		.when()
		.post(Routes.createUser)
		.then().log().all().extract().response();
		return response;
	}
	
	public static Response updateUser(userPayload payload,String username)
	{
		Response response=RestAssured.given()
		.baseUri(Routes.BaseUrl)
		.header("Content-Type","application/json")
		.body(payload)
		.pathParam("username", username)
		.log().all()
		.when()
		.put(Routes.updateUser)
		.then().log().all().extract().response();
		return response;
	}
	public static Response getUser(String username)
	{
		Response response=RestAssured.given()
		.baseUri(Routes.BaseUrl)
		.header("Content-Type","application/json")
		.pathParam("username", username)
		.log().all()
		.when()
		.get(Routes.getUser)
		.then().log().all().extract().response();
		return response;
	}
	public static Response deleteUser(String username)
	{
		Response response=RestAssured.given()
		.baseUri(Routes.BaseUrl)
		.header("Content-Type","application/json")
		.pathParam("username", username)
		.log().all()
		.when()
		.delete(Routes.deleteUser)
		.then().log().all().extract().response();
		return response;
	}

}
