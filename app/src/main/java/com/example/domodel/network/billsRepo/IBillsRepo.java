package com.example.domodel.network.billsRepo;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IBillsRepo {
    @GET("api/v1/bills")
    @Headers({"Content-Type: application/json",
            "Authorization: Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjAwNjgwODc3LCJleHAiOjE2MDE1NDQ4Nzd9.TQa-2xgsBAbHUCFmtvg3iYs0BlVDK5m9ppJM_3ZLQ0g"})
    Call<MainBillsRequestModel> loadInfo();
}
