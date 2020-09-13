package com.example.domodel.ui.payment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.domodel.InfoActivity;
import com.example.domodel.PayActivity;
import com.example.domodel.R;
import com.example.domodel.ui.news.NewsViewModel;

public class PaymentFragment extends Fragment {

    Button btnPay;
    Button btnPay2;
    Button btnPay3;
    private PaymentViewModel paymentViewModel;

    View.OnClickListener listenerPay = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent startPayActivity = new Intent(getActivity(), PayActivity.class);
            startActivity(startPayActivity);
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        paymentViewModel =
                ViewModelProviders.of(this).get(PaymentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_payment, container, false);
        btnPay = root.findViewById(R.id.btnPay);
        btnPay2 = root.findViewById(R.id.btnPay2);
        btnPay3 = root.findViewById(R.id.btnPay3);
        btnPay.setOnClickListener(listenerPay);
        btnPay2.setOnClickListener(listenerPay);
        btnPay3.setOnClickListener(listenerPay);
        return root;
    }
}
