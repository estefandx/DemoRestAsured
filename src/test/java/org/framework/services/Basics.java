package org.framework.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.http.ContentEncoding;

import static io.restassured.RestAssured.*;


public class Basics {

    public static void main(String[] args) {

        // probar estatus
        //validate if Add places API is Working as expectd
        //given - all input details
        // when - submit the api resource htttp method
        //THen - validate the response
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().queryParam("key","qaclick123")
                .header("Content-Type",ContentType.JSON)
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n")
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200);

        //http://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123
        //https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123




    }
}
