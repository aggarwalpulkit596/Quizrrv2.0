package com.quizrr;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClients {

    private static String PRODUCTION = "http://ec2-52-66-175-74.ap-south-1.compute.amazonaws.com:3000/";
    private static String DEVELOPER = "http://ec2-13-126-208-145.ap-south-1.compute.amazonaws.com:3000/";
    private static Retrofit retrofit = null;
    static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS).build();

    public static Retrofit getClient() {
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(PRODUCTION)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
        }
        return retrofit;
    }


}