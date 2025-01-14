package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	public static Response addPet(Pet payload){
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		.when()
		.post(Routes.addpet_url);
		
		
		return response;
	}
	public static Response deletePet(Integer petid){
		Response response = given()
				.pathParam("petid", petid)
		.when()
		.get(Routes.deletepet_url);
		
		
		return response;
	}

}