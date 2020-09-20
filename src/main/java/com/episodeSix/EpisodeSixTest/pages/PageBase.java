package com.episodeSix.EpisodeSixTest.pages;

import com.episodeSix.EpisodeSixTest.utils.Logger;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PageBase {
    protected Object value;
    protected RequestSpecification request;
    protected Response response;
    public static final String URL = "https://gorest.co.in/public-api/users";

    public PageBase(RequestSpecification request, Response response){
        this.request = request;
        this.response = response;
    }
    public boolean isStatusCode(Response response) {
        boolean status = false;
        int code = response.getStatusCode();

        if (code == 200) {
            status = true;
            Logger.printInfo("Status Code is " + code);
        }else
            Logger.printError("Status code is not 200, it was " + code + ". This is the error message: " + response.getBody().prettyPrint());
        return status;
    }
    public boolean isSchemaValid(Response response, String jsonFile) {
        boolean valid = false;

        try {
            response.then().body(matchesJsonSchemaInClasspath(jsonFile));
            valid = true;
            Logger.printInfo("Schema is valid");
        } catch (Exception e) {
            Logger.printError("Schema is invalid due to: ".concat(e.getMessage()));
        }
        return valid;
    }
}

