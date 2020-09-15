package com.example.domodel;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.domodel.network.AuthRepo;
import com.example.domodel.network.MainAuthReqModel;
import com.example.domodel.network.PostAuthModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    final private String LOGIN = "user";
    final private String PASSWORD = "user";
    private PostAuthModel pam;

    EditText textLogin;
    EditText textPassword;
    Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textLogin = findViewById(R.id.etLogin2);
        textPassword = findViewById(R.id.etPassword2);
        btnEnter = findViewById(R.id.btnEnter);

        btnEnter.setOnClickListener(enterClickListener);
    }

    View.OnClickListener enterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String login = textLogin.getText().toString();
            String password = textLogin.getText().toString();
            pam = new PostAuthModel();
            pam.username = login;
            pam.password = password;
            startAuth(pam);
            //if(checkLoginPassword()){
          //      showMsg(R.string.accessLogin);
          //  } else {
          //      showMsg(R.string.errorLogin);
            // }
        }
    };

    private void startAuth(PostAuthModel pam2){
        AuthRepo.getSingleton().getAPI().isAuth(pam2).enqueue(new Callback<MainAuthReqModel>() {
            @Override
            public void onResponse(@NonNull Call<MainAuthReqModel> call,
                                   @NonNull Response<MainAuthReqModel> response) {
                if (response.body() != null && response.isSuccessful()){
                    showMsg(R.string.accessLogin);
                    //textLogin.setText(response.body().token);
                    Intent startInfoActivity = new Intent(MainActivity.this, InfoActivity.class);
                    startActivity(startInfoActivity);
                } else {
                    showMsg(R.string.errorLogin);
                }

            }
            @Override
            public void onFailure(Call<MainAuthReqModel> call, Throwable t) {
                //showMsg(R.string.errorLogin);
                Toast.makeText(getApplicationContext(), "Ошибка подключения", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean checkLoginPassword(){
        return textLogin.getText().toString().equals(LOGIN) && textPassword.getText().toString().equals(PASSWORD);
    }

    private void showMsg(@StringRes int str){
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
}