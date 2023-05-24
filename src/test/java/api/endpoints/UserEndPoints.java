package api.endpoints;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

// Created for perform CRUD operations --> Create, Read, Update, Delete requests
public class UserEndPoints {



    public static ResourceBundle getUrl(){
        ResourceBundle config=ResourceBundle.getBundle("config"); // load properties file
        return config;
    }
    public static Response createUser(User payload){
        String post_url=getUrl().getString("post_url");
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_url);

        return response;
    }

    public static Response readUser(String username){
        String get_url=getUrl().getString("get_url");
        Response response=given()
                .pathParam("username",username)
                .when()
                .get(get_url);

        return response;
    }

    public static Response updateUser(String username,User payload){
        String update_url=getUrl().getString("update_url");
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
                .when()
                .put(update_url);

        return response;
    }

    public static Response deleteUser(String username){
        String delete_url=getUrl().getString("delete_url");
        Response response=given()
                .pathParam("username",username)
                .when()
                .delete(delete_url);

        return response;
    }
}
