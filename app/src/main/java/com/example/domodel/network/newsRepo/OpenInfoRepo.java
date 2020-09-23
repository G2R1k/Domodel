package com.example.domodel.network.newsRepo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenInfoRepo {
    private static OpenInfoRepo singleton = null;
    private IOpenInfo API;

    private OpenInfoRepo(){
        API = createAdapter();
    }

    public static OpenInfoRepo getSingleton(){
        if(singleton == null){
            singleton = new OpenInfoRepo();
        }
        return singleton;
    }

    public IOpenInfo getAPI(){
        return API;
    }

    private IOpenInfo createAdapter(){
        Retrofit retrofitAdapter = new Retrofit.Builder()
                .baseUrl("https://domodel.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitAdapter.create(IOpenInfo.class);
    }
}
