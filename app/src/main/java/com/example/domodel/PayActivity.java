package com.example.domodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PayActivity extends AppCompatActivity {

    Button btnBack;

    View.OnClickListener listenerClose = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        btnBack = findViewById(R.id.btnProfileBack);
        btnBack.setOnClickListener(listenerClose);
    }
}