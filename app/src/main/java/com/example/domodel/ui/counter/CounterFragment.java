package com.example.domodel.ui.counter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.domodel.R;

public class CounterFragment extends Fragment {

    private CounterViewModel counterViewModel;

    TextView fldColdWater;

    Button btnSendColdWater;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        counterViewModel =
                ViewModelProviders.of(this).get(CounterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_counter, container, false);

        fldColdWater = root.findViewById(R.id.fldColdWater2);
        btnSendColdWater = root.findViewById(R.id.btnCounterSend1);
        btnSendColdWater.setOnClickListener(listenerSendInfo);
        return root;
    }


    View.OnClickListener listenerSendInfo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str = "Данные отправленны!";
            Toast.makeText(getContext(), str, Toast.LENGTH_LONG).show();
            InputMethodManager imm = (InputMethodManager)getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(fldColdWater.getWindowToken(), 0);
            fldColdWater.clearFocus();
            fldColdWater.setText("");
        }
    };
}