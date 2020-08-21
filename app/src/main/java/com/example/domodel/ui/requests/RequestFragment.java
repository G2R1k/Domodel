package com.example.domodel.ui.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.domodel.R;

public class RequestFragment extends Fragment {

    Button btnSendRequest;

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

        btnSendRequest = root.findViewById(R.id.buttonSendRequest);
        btnSendRequest.setOnClickListener(listenerSendRequest);

        return root;
    }
}
