package com.example.domodel.ui.requests;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.domodel.R;

public class RequestFragment extends Fragment {

    Button btnSendRequest;
    TextView txtEditTextReq;

    private RequestViewModel requestViewModel;

    View.OnClickListener listenerSendRequest = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getContext(), "Спасибо, ваша заявка принята в работу!", Toast.LENGTH_LONG).show();
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        requestViewModel =
                ViewModelProviders.of(this).get(RequestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_request, container, false);

        txtEditTextReq = root.findViewById(R.id.editTextPersonName2);

        btnSendRequest = root.findViewById(R.id.buttonSendRequest);
        btnSendRequest.setOnClickListener(listenerSendRequest);

        return root;
    }
}
