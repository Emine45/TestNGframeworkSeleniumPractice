package com.techproed.testAPI.day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import static io.restassured.RestAssured.given;

public class Test1 {

//    Verify sorting hat
// 1.Send a get request to /sortingHat. Request includes :
// 2.Verify status code 200,
// 3.Verify the content type is application/json; charset=utf-8
// 4. Verify that response body contains one of the following houses:
// "Gryﬃndor", "Ravenclaw", "Slytherin", "Huﬄepuﬀ"

    String URI = "https://www.potterapi.com/";

    @Test
    public void verifySortingHat(){
        Response response = given().get(URI+ "v1/sortingHat");
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        System.out.println(response.prettyPrint());
        List<String> expectedHouses = Arrays.asList("\"Gryﬃndor\"", "\"Ravenclaw\"", "\"Slytherin\"", "\"Hufflepuff\"");
        Assert.assertTrue(expectedHouses.contains(response.body().asString()));
    }

    @Test
    public void verifyNoKey(){
        Response response = given().accept(ContentType.JSON).get(URI+ "v1/characters");
        Assert.assertEquals(response.statusCode(),409);
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        Assert.assertTrue(response.statusLine().contains("Conflict"));
        Assert.assertEquals(response.path("error"),"Must pass API key for request");
    }




}
