package com.example.domodel.network.billsRepo;

import com.google.gson.annotations.SerializedName;

public class MainBillsRequestModel {
    @SerializedName("bills") public BillsReqModel[] bills;
    @SerializedName("accounts") public AccReqModel[] accounts;
    @SerializedName("requisites") public ReqReqModel requisites;
}
