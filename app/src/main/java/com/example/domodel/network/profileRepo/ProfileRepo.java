package com.example.domodel.network.profileRepo;

import com.example.domodel.network.newsRepo.IOpenInfo;
import com.example.domodel.network.newsRepo.OpenInfoRepo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileRepo {
    private static ProfileRepo singleton = null;
    private IProfileRepo API;

    private ProfileRepo(){
        API = createAdapter();
    }

    public static ProfileRepo getSingleton(){
        if(singleton == null){
            singleton = new ProfileRepo();
        }
        return singleton;
    }

    public IProfileRepo getAPI(){
        return API;
    }

    private IProfileRepo createAdapter(){
        Retrofit retrofitAdapter = new Retrofit.Builder()
                .baseUrl("http://domodel.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitAdapter.create(IProfileRepo.class);
    }
}
