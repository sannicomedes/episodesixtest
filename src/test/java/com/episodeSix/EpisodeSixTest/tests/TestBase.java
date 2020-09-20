package com.episodeSix.EpisodeSixTest.tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import java.util.Random;

public class TestBase {
    private Random rand = new Random();
    protected RequestSpecification request;
    protected Response response;
    protected long randomNum = rand.nextLong();
    protected JSONObject jsonObject = new JSONObject();
}