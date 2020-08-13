package com.example.domodel.ui.counter;

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

public class CounterFragment extends Fragment {

    private CounterViewModel counterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        counterViewModel =
                ViewModelProviders.of(this).get(CounterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_counter, container, false);
        return root;
    }
}