package ru.dexsys;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class PetRequest
{
    private static final String baseUri = "https://petstore.swagger.io/v2/pet";
    private static final String body = "{\n" +
            "  \"id\": 1782,\n" +
            "  \"category\": {\n" +
            "    \"id\": 18,\n" +
            "    \"name\": \"doggies\"\n" +
            "  },\n" +
            "  \"name\": \"Tuzik\",\n" +
            "  \"photoUrls\": [\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 1, \n" +
            "      \"name\": \"tag1\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";

    private static final String updBody = "{\n" +
            "  \"id\": 1802,\n" +
            "  \"category\": {\n" +
            "    \"id\": 13,\n" +
            "    \"name\": \"doggies\"\n" +
            "  },\n" +
            "  \"name\": \"Lucky\",\n" +
            "  \"photoUrls\": [\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 2, \n" +
            "      \"name\": \"tag2\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"sold\"\n" +
            "}";

    public static void addPet() {
        RestAssured.given()
                .body(body)
                .contentType(ContentType.JSON)
                .post(baseUri)
                .then()
                .log()
                .ifValidationFails(LogDetail.ALL)
                .statusCode(200)
                .extract()
                .response()
                .body()
                .prettyPrint();
    }

    public static void updatePet(){
        RestAssured.given()
                .body(updBody)
                .contentType(ContentType.JSON)
                .post(baseUri)
                .then()
                .log().ifValidationFails(LogDetail.ALL)
                .statusCode(200)
                .extract()
                .response()
                .body()
                .prettyPrint();
    }

    public static void deletePet(int id){
        RestAssured.given()
                .baseUri(baseUri)
                .when()
                .delete("/{petId}", id)
                .then()
                .log().all()
                .statusCode(200);
    }

    public static void findPetById(int id){
        RestAssured.given()
                .baseUri(baseUri)
                .when()
                .get("/{petId}", id)
                .then()
                .log().all()
                .statusCode(200);
    }

    public static void findPetByStatus(PetStatus status) {
        RestAssured.given()
                .baseUri(baseUri)
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=" + status)
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract()
                .response();
    }
}