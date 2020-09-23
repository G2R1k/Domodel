package com.example.domodel.network.billsRepo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BillsReqModel {
    @SerializedName("id") public int id;
    @SerializedName("creationDate") public String creationDate;
    @SerializedName("target") public String target;
    @SerializedName("total") public float total;
    @SerializedName("type") public String type;
    @SerializedName("paymentStatus") public boolean paymentStatus;
    @SerializedName("account") public int account;
    @SerializedName("requisites") public int requisites;
    @SerializedName("calculations") public List<Object> calculations;
}
