package com.example.domodel;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final private String LOGIN = "user";
    final private String PASSWORD = "user";

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
            if(checkLoginPassword()){
                Intent startInfoActivity = new Intent(MainActivity.this, InfoActivity.class);
                startInfoActivity.putExtra(InfoActivity.LOGIN_KEY, textLogin.getText().toString());
                startInfoActivity.putExtra(InfoActivity.PASSWORD_KEY, textPassword.getText().toString());
                startActivity(startInfoActivity);
                showMsg(R.string.accessLogin);
            } else {
                showMsg(R.string.errorLogin);
            }
        }
    };

    private boolean checkLoginPassword(){
        return textLogin.getText().toString().equals(LOGIN) && textPassword.getText().toString().equals(PASSWORD);
    }

    private void showMsg(@StringRes int str){
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
}