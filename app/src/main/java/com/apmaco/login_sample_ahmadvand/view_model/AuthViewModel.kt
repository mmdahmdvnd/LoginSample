package com.apmaco.login_sample_ahmadvand.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apmaco.login_sample_ahmadvand.model.LoginRequest
import com.apmaco.login_sample_ahmadvand.repository.AuthRepository
import com.apmaco.login_sample_ahmadvand.utils.XmlParser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = AuthRepository()

    private val _loginResult = MutableLiveData<String>()
    val loginResult: LiveData<String> = _loginResult

    fun login(username: String, password: String) {
        val request = LoginRequest().apply {
            this.username = username
            this.password = password
        }

        repository.login(request, object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val xml = response.body()?.string() ?: ""
                    val result = XmlParser.extractTagValue(xml, "AuthenticateUserResult")
                    _loginResult.postValue(result)
                } else {
                    _loginResult.postValue("پاسخ ناموفق از سرور")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                _loginResult.postValue("خطا در اتصال: ${t.message}")
            }
        })
    }
}