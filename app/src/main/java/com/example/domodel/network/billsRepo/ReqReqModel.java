package com.example.domodel.network.billsRepo;

import com.google.gson.annotations.SerializedName;

public class ReqReqModel {
    @SerializedName("id") public int id;
    @SerializedName("companyName") public String companyName;
    @SerializedName("companyAddress") public String companyAddress;
    @SerializedName("inn") public int inn;
    @SerializedName("kpp") public int kpp;
    @SerializedName("ogrn") public int ogrn;
    @SerializedName("bankAccount") public String bankAccount;
    @SerializedName("bankName") public String bankName;
    @SerializedName("bik") public int bik;
    @SerializedName("correspondentAccount") public String correspondentAccount;
}

