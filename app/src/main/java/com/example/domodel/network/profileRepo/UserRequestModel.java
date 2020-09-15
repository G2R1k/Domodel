package com.example.domodel.network.profileRepo;

import com.google.gson.annotations.SerializedName;

public class UserRequestModel {
    @SerializedName("username") public String username;
    @SerializedName("firstName") public String firstName;
    @SerializedName("lastName") public String lastName;
    @SerializedName("patronymic") public String patronymic;
    @SerializedName("email") public String email;
    @SerializedName("photoLink") public String photoLink;
    @SerializedName("address") public String address;
    @SerializedName("phoneNumber") public String phoneNumber;
}
