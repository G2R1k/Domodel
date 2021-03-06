package com.example.domodel.ui.requisites;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.domodel.R;

public class ContactFragment extends Fragment {

    private ContactViewModel contactViewModel;

    Button btnOpenRequsities;
    Button btnPhone1;
    Button btnPhone2;
    Button btnPhone3;
    Button btnPhone4;

    TextView txtPhone1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactViewModel =
                ViewModelProviders.of(this).get(ContactViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        btnPhone1 = root.findViewById(R.id.btnPhone1);
        btnPhone2 = root.findViewById(R.id.btnPhone2);
        btnPhone3 = root.findViewById(R.id.btnPhone3);
        btnPhone4 = root.findViewById(R.id.btnPhone4);

        txtPhone1 = root.findViewById(R.id.txt_contact_phone1);

        btnPhone1.setOnClickListener(listenerDial);
        btnPhone2.setOnClickListener(listenerDial);
        btnPhone3.setOnClickListener(listenerDial);
        btnPhone4.setOnClickListener(listenerDial);

        btnOpenRequsities = root.findViewById(R.id.buttonToReq);
        btnOpenRequsities.setOnClickListener(listenerContact);

        return root;
    }

    View.OnClickListener listenerContact = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, RequisitesFragment.newInstance()).addToBackStack(RequisitesFragment.class.getName()).commit();
        }
    };

    View.OnClickListener listenerDial = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String phone;
            if(view == btnPhone1){
                phone = txtPhone1.getText().toString();
            } else if(view == btnPhone2){
                phone = txtPhone1.getText().toString();
            } else if(view == btnPhone3){
                phone = txtPhone1.getText().toString();
            } else {
                phone = txtPhone1.getText().toString();
            }
            Intent startDial = new Intent(Intent.ACTION_DIAL);
            startDial.setData(Uri.parse("tel:" + phone));
            startActivity(startDial);
        }
    };
}