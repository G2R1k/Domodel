package com.example.domodel.ui.counter;

import android.os.Bundle;
import android.text.TextUtils;
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

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CounterFragment extends Fragment {

    private CounterViewModel counterViewModel;

    TextView fldColdWater;

    Button btnSendColdWater;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        counterViewModel =
                ViewModelProviders.of(this).get(CounterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_counter2, container, false);

        fldColdWater = root.findViewById(R.id.fldColdWater2);
        btnSendColdWater = root.findViewById(R.id.btnCounterSend1);
        btnSendColdWater.setOnClickListener(listenerSendInfo);
        return root;
    }


    View.OnClickListener listenerSendInfo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str = fldColdWater.getText().toString();
            Toast.makeText(getContext(), str, Toast.LENGTH_LONG).show();
        }
    };
}