package com.example.domodel.ui.requisites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.domodel.R;

public class RequisitesFragment extends Fragment {

    private RequesitiesViewModel requesitiesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        requesitiesViewModel =
                ViewModelProviders.of(this).get(RequesitiesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_requisites, container, false);
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