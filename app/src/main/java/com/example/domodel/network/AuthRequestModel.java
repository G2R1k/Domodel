package com.example.domodel.network;

import com.google.gson.annotations.SerializedName;

public class AuthRequestModel {
    @SerializedName("roles") public RolesRequestModel[] roles;
    @SerializedName("admin") public String admin;
    @SerializedName("token") public String token;
}
