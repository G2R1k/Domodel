package com.example.domodel.ui.requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RequestViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RequestViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Новости");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
