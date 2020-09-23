package com.example.domodel.ui.payment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.domodel.InfoActivity;
import com.example.domodel.PayActivity;
import com.example.domodel.R;
import com.example.domodel.network.billsRepo.BillsRepo;
import com.example.domodel.network.billsRepo.MainBillsRequestModel;
import com.example.domodel.ui.news.NewsViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentFragment extends Fragment {

    Button btnPay;
    Button btnPay2;
    Button btnPay3;

    TextView txtBill1;
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

        txtBill1 = root.findViewById(R.id.txtBill1);
        updateInfo();

        return root;
    }

    private void updateInfo(){
        BillsRepo.getSingleton().getAPI().loadInfo()
                .enqueue(new Callback<MainBillsRequestModel>() {
                    @Override
                    public void onResponse(Call<MainBillsRequestModel> call, Response<MainBillsRequestModel> response) {
                        if (response.body() != null && response.isSuccessful()) {
                            Toast.makeText(getContext(), "/*Все ок */", Toast.LENGTH_SHORT).show();
                            renderInfo(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<MainBillsRequestModel> call, Throwable t) {
                        Toast.makeText(getContext(), "/*Ошибка данных*/", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void renderInfo(MainBillsRequestModel info){
        String str = info.bills[0].creationDate + " - " + info.bills[0].total;
        txtBill1.setText(str);
    }
}
