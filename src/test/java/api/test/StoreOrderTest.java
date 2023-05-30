package api.test;

import api.endpoints.StoreOrderEndPoints;
import api.endpoints.UserEndPoints;
import api.payloads.StoreOrder;
import api.payloads.User;
import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class StoreOrderTest {

    StoreOrder orderPayload;
    int orderId;
    @BeforeClass
    public void setupData(){
        Random random=new Random();
        int id=random.nextInt(0,100);
        orderPayload=new StoreOrder();
        orderPayload.setPetId(123);
        orderPayload.setId(id);
        orderPayload.setStatus("placed");
        orderPayload.setQuantity(1);
        orderPayload.setShipDate();
        orderPayload.setComplete(true);
    }

    @Test(priority = 1)
    public void testPostOrder(){
        Response response= StoreOrderEndPoints.createOrder(orderPayload);
        System.out.println(orderPayload.getShipDate());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        orderId=orderPayload.getId();
    }

    @Test(priority = 2)
    public void testGetOrder(){
        Response response=StoreOrderEndPoints.readOrder(orderId);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void testInventory(){
        Response response=StoreOrderEndPoints.readInventory();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testDeleteOrder(){
        Response response=StoreOrderEndPoints.deleteOrder(orderId);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
