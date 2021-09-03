package com.sk.retrofit_checkconnection;

import com.google.gson.annotations.Expose;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {

   @POST("retrofit_checkConnection.php")
   Call<PojoClass> checkDatabaseConnection();

//  send request
}
