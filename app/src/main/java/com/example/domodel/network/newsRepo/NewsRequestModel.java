package com.example.domodel.network.newsRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsRequestModel {
    @SerializedName("id") @Expose public int id;
    @SerializedName("creationDate") @Expose public String creationDate;
    @SerializedName("title") @Expose public String title;
    @SerializedName("shortText") @Expose public String shortText;
    @SerializedName("fullText") @Expose public String fullText;
    @SerializedName("pictureLink") @Expose public String pictureLink;
    @SerializedName("hidden") @Expose public boolean hidden;
    @SerializedName("pinned") @Expose public boolean pinned;
    @SerializedName("visible") @Expose public boolean visible;
    @SerializedName("authorName") @Expose public String authorName;
}
