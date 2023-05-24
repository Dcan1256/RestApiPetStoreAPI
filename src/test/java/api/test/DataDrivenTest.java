package api.test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {


    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String userID, String username, String fname, String lname, String useremail
    , String pwd, String ph){
        User userPayload=new User();

        userPayload.setId(Integer.parseInt(userID));
        userPayload.setUsername(username);
        userPayload.setFirstname(fname);
        userPayload.setLastName(lname);
        userPayload.setEmail(useremail);
        userPayload.setPassword(pwd);
        userPayload.setPhone(ph);

        Response response= UserEndPoints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUser(String userName){
        Response response=UserEndPoints.deleteUser(userName);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
