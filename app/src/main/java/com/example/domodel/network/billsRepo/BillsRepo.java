package com.example.domodel.network.billsRepo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BillsRepo {
    private static BillsRepo singleton = null;
    private IBillsRepo API;

    private BillsRepo(){
        API = createAdapter();
    }

    public static BillsRepo getSingleton(){
        if(singleton == null){
            singleton = new BillsRepo();
        }
            return singleton;
    }

    public IBillsRepo getAPI(){
        return API;
    }

    private IBillsRepo createAdapter() {
        Retrofit retrofitAdapter = new Retrofit.Builder()
                .baseUrl("https://domodel.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitAdapter.create(IBillsRepo.class);
    }
}
