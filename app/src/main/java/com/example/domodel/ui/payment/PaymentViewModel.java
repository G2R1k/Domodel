package com.example.domodel.ui.payment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PaymentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PaymentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Новости");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
