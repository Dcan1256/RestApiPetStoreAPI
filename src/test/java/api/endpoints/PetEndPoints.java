package api.endpoints;

import api.payloads.Pet;
import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class PetEndPoints {
    public static ResourceBundle getUrl(){
        ResourceBundle config=ResourceBundle.getBundle("config"); // load properties file
        return config;
    }
    public static Response createPet(Pet payload){
        String post_pet_url=getUrl().getString("post_pet_url");
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_pet_url);

        return response;
    }

    public static Response readPet(int id){
        String get_pet_url=getUrl().getString("get_pet_url");
        Response response=given()
                .pathParam("petId",id)
                .when()
                .get(get_pet_url);

        return response;
    }

    public static Response deletePet(int id){
        String delete_pet_url=getUrl().getString("delete_pet_url");
        Response response=given()
                .pathParam("petId", id)
                .when()
                .delete(delete_pet_url);

        return response;
    }
}
