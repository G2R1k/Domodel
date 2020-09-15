package com.example.domodel.network.profileRepo;

import com.google.gson.annotations.SerializedName;

public class MainProfileReqModel {
    @SerializedName("accounts") public AccReqModel[] accounts;
    @SerializedName("user") public UserRequestModel user;
}
