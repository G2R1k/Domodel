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

    View.OnClickListener listenerContact = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, RequisitesFragment.newInstance()).addToBackStack(RequisitesFragment.class.getName()).commit();
        }
    };

    View.OnClickListener listenerDial = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String phone = ((TextView)view).getText().toString();
            Intent startDial = new Intent(Intent.ACTION_DIAL);
            startDial.setData(Uri.parse("tel:" + phone));
            startActivity(startDial);
        }
    };
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactViewModel =
                ViewModelProviders.of(this).get(ContactViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        btnPhone1 = root.findViewById(R.id.btnPhone1);
        btnPhone2 = root.findViewById(R.id.btnPhone2);
        btnPhone3 = root.findViewById(R.id.btnPhone3);
        btnPhone4 = root.findViewById(R.id.btnPhone4);

        btnPhone1.setOnClickListener(listenerDial);
        btnPhone2.setOnClickListener(listenerDial);
        btnPhone3.setOnClickListener(listenerDial);
        btnPhone4.setOnClickListener(listenerDial);

        btnOpenRequsities = root.findViewById(R.id.buttonToReq);
        btnOpenRequsities.setOnClickListener(listenerContact);
//        final TextView textView = root.findViewById(R.id.text_notifications);
//        requesitiesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}