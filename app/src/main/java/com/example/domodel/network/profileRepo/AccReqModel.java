package com.example.domodel.network.profileRepo;

import com.google.gson.annotations.SerializedName;

public class AccReqModel {
    @SerializedName("id") public int id;
    @SerializedName("address") public String address;
    @SerializedName("houseNumber") public String houseNumber;
    @SerializedName("acresAmount") public float acresAmount;
}
