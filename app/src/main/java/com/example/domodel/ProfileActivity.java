package com.example.domodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.domodel.network.profileRepo.MainProfileReqModel;
import com.example.domodel.network.profileRepo.ProfileRepo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    Button btnBack;

    TextView txtFIO;
    TextView txtNumber;
    TextView txtEmail;
    TextView txtMail;
    TextView txtAddress;
    TextView txtAcres;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnBack = findViewById(R.id.btnProfileBack);
        btnBack.setOnClickListener(listenerFinishProfileActivity);

        txtFIO = findViewById(R.id.txt_fio);
        txtNumber = findViewById(R.id.txt_number);
        txtEmail = findViewById(R.id.txt_email);
        txtMail = findViewById(R.id.txt_mail);
        txtAddress = findViewById(R.id.txt_adress2);
        txtAcres = findViewById(R.id.txt_acres);

        updateProfile();
    }

    private void updateProfile(){
        ProfileRepo.getSingleton().getAPI().loadInfo().enqueue(new Callback<MainProfileReqModel>() {
            @Override
            public void onResponse(Call<MainProfileReqModel> call, Response<MainProfileReqModel> response) {
                if (response.body() != null && response.isSuccessful()){
                    renderProfile(response.body());
                }
            }

            @Override
            public void onFailure(Call<MainProfileReqModel> call, Throwable t) {

            }
        });
    }

    private void renderProfile(MainProfileReqModel body) {
        String strFIO = body.user.lastName + " " + body.user.firstName;
        txtFIO.setText(strFIO);
        txtNumber.setText(body.user.phoneNumber);
        txtEmail.setText(body.user.email);
        txtMail.setText(body.user.address);
        txtAddress.setText(body.accounts[0].address);
        String acres = Float.toString(body.accounts[0].acresAmount) + " соток";
        txtAcres.setText(acres);
    }

    View.OnClickListener listenerFinishProfileActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}
