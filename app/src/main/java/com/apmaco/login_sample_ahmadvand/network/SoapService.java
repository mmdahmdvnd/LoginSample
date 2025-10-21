package com.apmaco.login_sample_ahmadvand.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SoapService {
    @POST("your-method")
    @Headers({
        "Content-Type: text/xml; charset=utf-8",
        "SOAPAction: \"http://apmaco.com/AuthenticateUser\""
    })
    Call<ResponseBody> authenticateUser(@Body RequestBody body);
}