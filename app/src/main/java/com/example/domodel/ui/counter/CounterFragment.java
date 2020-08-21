package com.example.domodel.ui.counter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.domodel.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CounterFragment extends Fragment {

    private CounterViewModel counterViewModel;
    private Button btnSend;
    private TextView textNumberCounter;
    private TextView textDate;
    private TextView textCounter;
    private TextView fieldGetInfo;
    String dateText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        counterViewModel =
                ViewModelProviders.of(this).get(CounterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_counter, container, false);
        textNumberCounter = root.findViewById(R.id.textNumberCounter);
        textDate = root.findViewById(R.id.textDate);
        textCounter = root.findViewById(R.id.textCounter);
        fieldGetInfo = root.findViewById(R.id.editTextTextPersonName2);

        btnSend = root.findViewById(R.id.buttonSend);
        btnSend.setOnClickListener(listenerSendInfo);

        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        dateText = dateFormat.format(currentDate);
        return root;
    }


    View.OnClickListener listenerSendInfo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            textNumberCounter.setText("45 685214");
            textDate.setText(dateText);
            textCounter.setText(fieldGetInfo.getText().toString());
            Toast.makeText(getContext(), "Данные отправленны !", Toast.LENGTH_LONG).show();
        }
    };
}