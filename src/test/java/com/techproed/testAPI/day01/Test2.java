package com.techproed.testAPI.day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class Test2 {
//    Verify number of character with key
//1.1. Send a get request to /characters. Request includes :
// • Header Accept with value application/json
//• Query param key with value {{apiKey}}
//2. Verify status code 200, content type application/json; charset=utf-8
// 3. Verify response contains 195 characters


    String URI = "https://www.potterapi.com/";

    String ApiKey = "$2a$10$XBdL8H7cCL1D0dj2X8hnoOjLjaZntWf0Ns/6jxLv/ZKdEltXCHh9m";

    @Test
    public void numberOfCharacters() {
        Response response = given().accept(ContentType.JSON).when().queryParam("key", ApiKey).
                get(URI + "v1/characters");
        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json; charset=utf-8");
        List<Map<String, Object>> listCharacters = response.as(List.class);
        List<String> allNames = response.path("name");
        System.out.println("allNames = " + allNames);
        assertTrue(allNames.contains("Katie Bell"));
        assertEquals(listCharacters.size(), 195);
    }


    @Test
    public void nameSearch() {
        Response response = given().accept(ContentType.JSON).when().queryParam("key", ApiKey).
                queryParam("name", "Harry Potter").get(URI + "v1/characters");
        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json; charset=utf-8");
        List<Map<String, Object>> harryPotter = response.as(List.class);
        assertEquals(harryPotter.get(0).get("name"), "Harry Potter");
        System.out.println(response.<Double>path("name"));
    }
}