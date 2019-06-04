package com.example.android4thassignment;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class Url {

    public static final String BASE_URL="http://10.0.2.2:8002/";
    static String accessTooke;
    public static Retrofit getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static String getAccessTooke() {
        return accessTooke;
    }

    public static void setAccessTooke(String accessTooke) {
        Url.accessTooke = accessTooke;
    }
}
