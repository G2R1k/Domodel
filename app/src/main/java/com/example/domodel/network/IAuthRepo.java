package com.example.domodel.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAuthRepo {
    @POST("api/v1/auth/login")
    Call<MainAuthReqModel> isAuth(@Body PostAuthModel pam);
}
