package com.example.domodel.ui.requisites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RequesitiesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RequesitiesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Реквизиты");
    }

    public LiveData<String> getText() {
        return mText;
    }
}