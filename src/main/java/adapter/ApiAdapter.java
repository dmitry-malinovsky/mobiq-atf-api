package adapter;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiAdapter {

    public Response get(String path){
        return prepareSpecification().get(path);
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
