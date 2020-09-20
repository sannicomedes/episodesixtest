package com.episodeSix.EpisodeSixTest.utils;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RequestHeader {
    //Headers Keys
    public static final String AUTHORIZATION_KEY = "Authorization";
    public static final String ACCEPT_KEY = "Accept";
    public static final String CONTENT_TYPE_KEY = "Content-Type";
    //Headers Values
    public static final String AUTHORIZATION_VALUE = "Bearer 6d780e8c5119868f57f05f7b3f47a720c8f7dec42b2a2cb4d8cba11cf1c46209";
    public static final String ACCEPT_VALUE = "application/json";
    public static final String CONTENT_TYPE_VALUE = "application/json";

    public static Headers getRequestHeaders(){
        List<Header> list = new ArrayList<Header>();
        list.add(new Header(AUTHORIZATION_KEY, AUTHORIZATION_VALUE));
        list.add(new Header(ACCEPT_KEY, ACCEPT_VALUE));
        list.add(new Header(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE));
        return new Headers(list);
    }
}
