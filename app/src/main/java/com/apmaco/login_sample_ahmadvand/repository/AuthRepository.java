package com.apmaco.login_sample_ahmadvand.repository;

import com.apmaco.login_sample_ahmadvand.model.LoginRequest;
import com.apmaco.login_sample_ahmadvand.network.RetrofitClient;
import com.apmaco.login_sample_ahmadvand.network.SoapEnvelopeBuilder;
import com.apmaco.login_sample_ahmadvand.network.SoapService;
import com.apmaco.login_sample_ahmadvand.utils.CryptoUtils;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class AuthRepository {
    private final SoapService service;

    public AuthRepository() {
        this.service = RetrofitClient.getService();
    }

    public void login(LoginRequest request, Callback<ResponseBody> callback) {
        try {
            String encryptedJson = CryptoUtils.encrypt(request.toJson());
            RequestBody body = SoapEnvelopeBuilder.build(encryptedJson);
            Call<ResponseBody> call = service.authenticateUser(body);
            call.enqueue(callback);
        } catch (Exception e) {
            callback.onFailure(null, e);
        }
    }
}