package com.example.domodel.network.billsRepo;

import com.google.gson.annotations.SerializedName;

public class AccReqModel {
    @SerializedName("id") public int id;
    @SerializedName("address") public String address;
    @SerializedName("houseNumber") public String houseNumber;
    @SerializedName("acresAmount") public int acresAmount;
}
