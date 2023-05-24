package api.test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import com.beust.ah.A;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

public class UserTests {
    Faker faker;
    User userPayload;

    public Logger logger; // for logs
    @BeforeClass
    public void setupData(){
        faker=new Faker();
        userPayload=new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        // logs
        logger= LogManager.getLogger(this.getClass());

    }
    @Test(priority = 1)
    public void testPostUser(){

        logger.info("***********  Creating user  ***********");
        Response response=UserEndPoints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("***********  User Created  ***********");
    }

    @Test(priority = 2)
    public void testGetUser(){

        logger.info("***********  Reading user Info  ***********");
        Response response=UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("***********  User info is displayed ***********");
    }

    @Test(priority = 3)
    public void testUpdateUser(){

        logger.info("***********  Updating user  ***********");
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());

        Response response=UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("***********  User is updated  ***********");

    }

    @Test(priority = 4)
    public void testDeleteUser(){

        logger.info("***********  Deleting user  ***********");
        Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("***********  User is deleted  ***********");

        
    }
}
