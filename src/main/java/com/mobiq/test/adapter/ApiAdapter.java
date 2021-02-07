package com.mobiq.test.adapter;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class ApiAdapter {

    public Response get(String path){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(path).then()
                .extract().response();
    }

    public Response delete(String path){
        return prepareSpecification().delete(path);
    }

    public Response put(String path){
        return prepareSpecification().put(path);
    }

    private RequestSpecification prepareSpecification(){
        return given().relaxedHTTPSValidation();
    }
}
