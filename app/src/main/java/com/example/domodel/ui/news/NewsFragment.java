package com.example.domodel.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.domodel.R;
import com.example.domodel.network.newsRepo.MainRequestModel;
import com.example.domodel.network.newsRepo.OpenInfoRepo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    private NewsViewModel newsViewModel;

    TextView textNews1;
    TextView textNews2;
    TextView dateNews1;
    TextView dateNews2;
    TextView nameAuthor1;
    TextView nameAuthor2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsViewModel =
                ViewModelProviders.of(this).get(NewsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        textNews1 = root.findViewById(R.id.textNews);
        textNews2 = root.findViewById(R.id.textNews3);
        dateNews1 = root.findViewById(R.id.dateNews1);
        dateNews2 = root.findViewById(R.id.dateNews2);
        nameAuthor1 = root.findViewById(R.id.nameAuthor1);
        nameAuthor2 = root.findViewById(R.id.nameAuthor2);
        updateInfo();
        return root;
    }

    private void updateInfo() {
        OpenInfoRepo.getSingleton().getAPI().loadInfo()
                .enqueue(new Callback<MainRequestModel>() {
                    @Override
                    public void onResponse(@NonNull Call<MainRequestModel> call,
                                           @NonNull Response<MainRequestModel> response) {
                        if (response.body() != null && response.isSuccessful()) {
                            Toast.makeText(getContext(), "/*Все ок */", Toast.LENGTH_SHORT).show();
                            renderInfo(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<MainRequestModel> call,
                                          Throwable t) {
                        Toast.makeText(getContext(), "/*Ошибка данных*/", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void renderInfo(MainRequestModel model){
        textNews1.setText(model.shortText);
        dateNews1.setText(model.creationDate);
        nameAuthor1.setText(model.authorName);
    }
}