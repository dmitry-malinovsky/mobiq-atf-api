package com.mobiq.test.adapter;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
@Log4j
public class ApiAdapter {

    public Response get(String path){
        log.info("Sending GET request to: " + path);
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(path).then()
                .extract().response();
        log.info("Response code: " + response.getStatusCode());
        return response;
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
