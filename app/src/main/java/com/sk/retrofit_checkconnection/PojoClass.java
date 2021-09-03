package com.sk.retrofit_checkconnection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoClass {

   @SerializedName("success")
    @Expose
    int success;

    @SerializedName("message")
    @Expose
    String message;

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
