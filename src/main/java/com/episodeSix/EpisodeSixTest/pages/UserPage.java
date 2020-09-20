package com.episodeSix.EpisodeSixTest.pages;

import com.episodeSix.EpisodeSixTest.utils.Logger;
import com.episodeSix.EpisodeSixTest.utils.RequestHeader;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UserPage extends PageBase {
    public UserPage(RequestSpecification request, Response response) {
        super(request, response);
    }

    public Response getUserDetails(int id) {
        baseURI = URL + "/" + id;
        request = given();
        response = request.get();
        return response;
    }

    public Response createNewUser(JSONObject newUser) {
        baseURI = URL;
        request = given().headers(RequestHeader.getRequestHeaders());
        request.body(newUser.toJSONString());
        response = request.post();
        if (response != null) {
            Logger.printInfo("User was Created successfully");
        }
        return response;
    }
    public boolean isDataExpected(Response response, JSONObject jsonObject) {
        boolean expected = false;

        String name = (String) response.jsonPath().getMap("data").get("name");
        String email = (String) response.jsonPath().getMap("data").get("email");
        String gender = (String) response.jsonPath().getMap("data").get("gender");
        String status = (String) response.jsonPath().getMap("data").get("status");

        if ((jsonObject.get("name").toString().equalsIgnoreCase(name)) && (jsonObject.get("email").toString().equalsIgnoreCase(email))
                && (jsonObject.get("gender").toString().equalsIgnoreCase(gender))
                && (jsonObject.get("status").toString().equalsIgnoreCase(status))) {
            expected = true;
            Logger.printInfo("Data matches User created one");
        }
        return expected;
    }
    public Response updateUser(JSONObject jsonObject, int id) {
        baseURI = URL + "/" + id;
        request = given().headers(RequestHeader.getRequestHeaders());
        request.body(jsonObject.toJSONString());
        response = request.put();
        if (response != null) {
            Logger.printInfo("User was Updated successfully");
        }
        return response;
    }
}
