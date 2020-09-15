package com.example.domodel.network.profileRepo;

import com.example.domodel.network.newsRepo.NewsRequestModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IProfileRepo {
    @GET("api/v1/profile")
    @Headers({"Content-Type: application/json",
            "Authorization: Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNTk5NjAyNDI3LCJleHAiOjE2MDA0NjY0Mjd9.i4cLl5u7cZFjKY-5Io7jgtufB_vMCEQOFMitEdKRVCQ"})
    Call<MainProfileReqModel> loadInfo();
}
