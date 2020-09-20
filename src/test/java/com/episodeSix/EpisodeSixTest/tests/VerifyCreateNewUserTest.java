package com.episodeSix.EpisodeSixTest.tests;

import com.episodeSix.EpisodeSixTest.pages.UserPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class VerifyCreateNewUserTest extends TestBase {
    UserPage user = new UserPage(request, response);

    @Test()
    @DisplayName("Create New User")
    public void createUser()
    {
        jsonObject.put("name", "JoseRamirez+" + randomNum);
        jsonObject.put("gender", "Male");
        jsonObject.put("email", "jramirez+" + randomNum + "@ramirez.com");
        jsonObject.put("status", "Active");
        response = user.createNewUser(jsonObject);
        Assert.assertTrue(user.isStatusCode(response));
        Assert.assertEquals(201, response.jsonPath().get("code"));
        Assert.assertTrue(user.isDataExpected(response, jsonObject));
    }
}