package com.apiRequests;

import java.net.MalformedURLException;
import java.net.URL;

public class URLBuilder {

    private static final String HOST = "https://swapi.co/api";

    private static URL build(String url){
        try{
            return new URL(url);
        } catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }

    public static URL people(String userId) {
        StringBuilder sb = new StringBuilder(HOST).append("/").append("people").append("/").append(userId);
        return build(sb.toString());
    }

}
