package api.test;

import api.endpoints.PetEndPoints;
import api.endpoints.StoreOrderEndPoints;
import api.payloads.Category;
import api.payloads.Pet;
import api.payloads.StoreOrder;
import api.payloads.Tag;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class PetTest {
    Pet petPayload;
    Tag tagPayload;
    Category categoryPayload;
    int petId;

    @BeforeClass
    public void setupData(){
        categoryPayload=new Category();
        tagPayload=new Tag();
        petPayload=new Pet();
        Random random=new Random();
        int categoryId=random.nextInt(0,100);
        int tagId=random.nextInt(0,100);
        int petId=random.nextInt(0,100);
        categoryPayload.setId(categoryId);
        categoryPayload.setName("cat");
        tagPayload.setId(tagId);
        tagPayload.setName("Gatto");
        petPayload.setCategory(categoryPayload);
        petPayload.setTag(tagPayload);
        petPayload.setId(petId);
        petPayload.setName("Gatto");
        petPayload.setStatus("available");
    }

    @Test(priority = 1)
    public void testPostPet(){
        Response response= PetEndPoints.createPet(petPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        petId=petPayload.getId();
    }

    @Test(priority = 2)
    public void testGetPet(){
        Response response=PetEndPoints.readPet(petId);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void testDeleteOrder(){
        Response response=PetEndPoints.deletePet(petId);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
