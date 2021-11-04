package com.moringaschool.exchangerateapp.retrofit;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {
    @GET("v6/latest/{currency}")
    Call<JsonObject> getExchangeCurrency(@Path("currency") String currency);
}
