package com.example.domodel.ui.requisites;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.domodel.R;
import com.example.domodel.network.billsRepo.BillsRepo;
import com.example.domodel.network.billsRepo.MainBillsRequestModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequisitesFragment extends Fragment {

    Button btnBackToContact;

    TextView companyName;
    TextView companyAddress;
    TextView txtBankAcc;
    TextView txtINN;
    TextView txtKPP;
    TextView txtORGN;
    TextView txtBankName;
    TextView txtBIK;
    TextView txtCorAcc;


    View.OnClickListener listenerBack = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getFragmentManager().popBackStack();
        }
    };

    public static RequisitesFragment newInstance() {
        return new RequisitesFragment();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_requisites, container, false);
        btnBackToContact = view.findViewById(R.id.btnToContact);
        btnBackToContact.setOnClickListener(listenerBack);

        companyName = view.findViewById(R.id.companyName);
        companyAddress = view.findViewById(R.id.companyAddress);
        txtBankAcc = view.findViewById(R.id.txtBankAcc);
        txtINN = view.findViewById(R.id.txtINN);
        txtKPP = view.findViewById(R.id.txtKPP);
        txtORGN = view.findViewById(R.id.txtORGN);
        txtBankName = view.findViewById(R.id.txtBankName);
        txtBIK = view.findViewById(R.id.txtBIK);
        txtCorAcc = view.findViewById(R.id.txtCorAcc);
        loadInfo();
        return view;
    }

    private void loadInfo(){
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
                        Toast.makeText(getContext(), "Ошибка данных", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void renderInfo(MainBillsRequestModel model){
        String strName = model.requisites.companyName;
        String strAddress = model.requisites.companyAddress;
        String strBankAcc = model.requisites.bankAccount;
        String strINN = model.requisites.inn + "";
        String strKPP = model.requisites.kpp + "";
        String strORGN = model.requisites.ogrn + "";
        String strBankName = model.requisites.bankName;
        String strBik = model.requisites.bik + "";
        String strCorAcc = model.requisites.correspondentAccount;

        companyName.setText(strName);
        companyAddress.setText(strAddress);
        txtBankAcc.setText(strBankAcc);
        txtINN.setText(strINN);
        txtKPP.setText(strKPP);
        txtORGN.setText(strORGN);
        txtBankName.setText(strBankName);
        txtBIK.setText(strBik);
        txtCorAcc.setText(strCorAcc);
    }
}
