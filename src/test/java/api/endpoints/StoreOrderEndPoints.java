package api.endpoints;
import api.payloads.StoreOrder;
import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static api.endpoints.UserEndPoints.getUrl;
import static io.restassured.RestAssured.given;

public class StoreOrderEndPoints {

    public static ResourceBundle getURl(){
        ResourceBundle rb=ResourceBundle.getBundle("config");
        return rb;
    }

    public static Response createOrder(StoreOrder payload){
        String post_order_url=getURl().getString("post_order_url");
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_order_url);

        return response;
    }

    public static Response readOrder(int id){
        String get_order_url=getUrl().getString("get_order_url");
        Response response=given()
                .pathParam("orderId",id)
                .when()
                .get(get_order_url);

        return response;
    }

    public static Response deleteOrder(int id){
        String delete_order_url=getUrl().getString("delete_order_url");
        Response response=given()
                .pathParam("orderId",id)
                .when()
                .delete(delete_order_url);

        return response;
    }

    public static Response readInventory(){
        String get_inventory_url= getURl().getString("get_inventory_url");
        Response response=given()
                .when()
                .get(get_inventory_url);

        return response;
    }

}
