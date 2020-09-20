package com.episodeSix.EpisodeSixTest.tests;

import com.episodeSix.EpisodeSixTest.pages.UserPage;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class VerifyUserDetailsTest extends TestBase {
    UserPage user = new UserPage(request, response);

    @Test()
    @DisplayName("Get User Details")
    public void getUserDetails()
    {
        jsonObject.put("name", "JoseRamirez+" + randomNum);
        jsonObject.put("gender", "Male");
        jsonObject.put("email", "jramirez+" + randomNum + "@ramirez.com");
        jsonObject.put("status", "Active");
        response = user.createNewUser(jsonObject);
        response = user.getUserDetails((Integer) response.jsonPath().getMap("data").get("id"));
        Assert.assertTrue(user.isStatusCode(response));
        Assert.assertTrue(user.isDataExpected(response, jsonObject));
    }
}