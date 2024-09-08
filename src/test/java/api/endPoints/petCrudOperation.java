package api.endPoints;

import api.Payload.petPayload;
import api.Payload.userPayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class petCrudOperation {

	public static Response createPet(petPayload payload) {
		Response response = RestAssured.given().baseUri(Routes.BaseUrl).header("Content-Type", "application/json")
				.body(payload).log().all().when().post(Routes.createPet).then().log().all().extract().response();
		return response;
	}

	public static Response updatePet(petPayload payload, int petId) {
		Response response = RestAssured.given().baseUri(Routes.BaseUrl).header("Content-Type", "application/json")
				.body(payload).pathParam("petId", petId).log().all().when().put(Routes.updatePet).then().log().all()
				.extract().response();
		return response;
	}

	public static Response getPet(int petId) {
		Response response = RestAssured.given().baseUri(Routes.BaseUrl).header("Content-Type", "application/json")
				.pathParam("petId", petId).log().all().when().get(Routes.getPet).then().log().all().extract()
				.response();
		return response;
	}

	public static Response deletePet(int petId) {
		Response response = RestAssured.given().baseUri(Routes.BaseUrl).header("Content-Type", "application/json")
				.pathParam("petId", petId).log().all().when().delete(Routes.deletePet).then().log().all().extract()
				.response();
		return response;
	}

}
