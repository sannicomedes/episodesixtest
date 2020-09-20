package com.episodeSix.EpisodeSixTest.tests;

import com.episodeSix.EpisodeSixTest.pages.UserPage;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class VerifyUpdateUserTest extends TestBase {
    UserPage user = new UserPage(request, response);

    @Test()
    @DisplayName("Update User")
    public void updateUser()
    {
        jsonObject.put("name", "JoseRamirez" + randomNum);
        jsonObject.put("gender", "Male");
        jsonObject.put("email", "jramirez+" + randomNum + "@ramirez.com");
        jsonObject.put("status", "Active");
        response = user.createNewUser(jsonObject);
        jsonObject.put("name", "UPDATED JoseRamirez" + randomNum);
        jsonObject.put("gender", "Male");
        jsonObject.put("email", "UPDATED jramirez+" + randomNum + "@ramirez.com");
        jsonObject.put("status", "Active");
        response = user.updateUser(jsonObject, (Integer) response.jsonPath().getMap("data").get("id"));
        Assert.assertTrue(user.isStatusCode(response));
        Assert.assertTrue(user.isDataExpected(response, jsonObject));
    }
}