package com.example.domodel.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthRepo {
    private static AuthRepo singleton = null;
    private IAuthRepo API;

    private AuthRepo(){
        API = createAdapter();
    }

    public static AuthRepo getSingleton(){
        if(singleton == null){
            singleton = new AuthRepo();
        }
        return singleton;
    }

    public IAuthRepo getAPI(){
        return API;
    }

    private IAuthRepo createAdapter(){
        Retrofit retrofitAdapter = new Retrofit.Builder()
                .baseUrl("http://domodel.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitAdapter.create(IAuthRepo.class);
    }
}
