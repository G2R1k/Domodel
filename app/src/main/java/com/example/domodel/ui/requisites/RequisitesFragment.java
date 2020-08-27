package com.example.domodel.ui.requisites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.domodel.R;

public class RequisitesFragment extends Fragment {

    Button btnBackToContact;

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
        return view;
    }
}
