package com.apmaco.login_sample_ahmadvand.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class RetrofitClient {
    private static final String BASE_URL = "your url";
    private static Retrofit retrofit;

    public static SoapService getService() {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

            retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .build();
        }
        return retrofit.create(SoapService.class);
    }
}