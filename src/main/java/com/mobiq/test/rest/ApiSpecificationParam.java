package com.mobiq.test.rest;

import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.http.entity.ContentType.MULTIPART_FORM_DATA;


public enum ApiSpecificationParam {
    BASE_URI("base-uri") {
        public RequestSpecification buildReq(RequestSpecification requestSpecification, Map<String, Object> params) {
            return requestSpecification.baseUri(params.get("uri").toString());
        }
    },
    CONTENT_TYPE("content-type") {
        public RequestSpecification buildReq(RequestSpecification requestSpecification, Map<String, Object> params) {
            return requestSpecification.contentType(params.get("content-type").toString());
        }
    },
    HEADERS("headers") {
        public RequestSpecification buildReq(RequestSpecification requestSpecification, Map<String, Object> params) {
            return requestSpecification.headers(params);
        }
    },
    PARAMS("params") {
        public RequestSpecification buildReq(RequestSpecification requestSpecification, Map<String, Object> params) {
            return requestSpecification.params(params);
        }
    },
    BODY("BODY") {
        public RequestSpecification buildReq(RequestSpecification requestSpecification, Map<String, Object> params) {
            return requestSpecification.body(params);
        }
    },
    PATH_PARAM("path-param") {
        public RequestSpecification buildReq(RequestSpecification requestSpecification, Map<String, Object> params) {
            return requestSpecification.pathParams(params);
        }
    },
    AUTHENTICATION("auth") {
        public RequestSpecification buildReq(RequestSpecification requestSpecification, Map<String, Object> params) {
            String username = null;
            String password = null;

            for(Map.Entry<String, Object> entry : params.entrySet()){
              username = entry.getKey();
              password = (String) entry.getValue();
            }
            return requestSpecification.auth().preemptive().basic(username,password);
        }
    },
    TOKEN_AUTH("token-auth") {
        public RequestSpecification buildReq(RequestSpecification requestSpecification, Map<String, Object> params) {
            String token = (String)params.get("token");
            return requestSpecification.auth().oauth2(token);
        }
    },

    FORM_DATA("form-data") {
        public RequestSpecification buildReq(RequestSpecification requestSpecification, Map<String, Object> params) {
          for (Map.Entry<String, Object> entry : params.entrySet()){
                if (entry.getValue() instanceof File){
                    requestSpecification.multiPart(entry.getKey(), (File)entry.getValue());
                }
                else {
                    requestSpecification.formParam(entry.getKey(), entry.getValue());
                }
          }
          return requestSpecification.contentType(MULTIPART_FORM_DATA.getMimeType());
        }
    };

    private static final Map<String, ApiSpecificationParam> LOOKUP = EnumSet.allOf(ApiSpecificationParam.class).stream().collect(Collectors.toMap(ApiSpecificationParam::getType, e -> e));

    private String type;

    ApiSpecificationParam(String type) {
        this.type = type;
    }

    abstract RequestSpecification buildReq(RequestSpecification requestSpecification, Map<String, Object> params);

    public String getType() {
        return type;
    }

    static ApiSpecificationParam getSpec(String spec){
        return  LOOKUP.get(spec);
    }
}
