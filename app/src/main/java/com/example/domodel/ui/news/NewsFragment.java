package com.example.domodel.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.domodel.R;
import com.example.domodel.network.newsRepo.NewsRequestModel;
import com.example.domodel.network.newsRepo.OpenInfoRepo;
import com.example.domodel.ui.requisites.RequisitesFragment;

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

    Button btnToVotes;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsViewModel =
                ViewModelProviders.of(this).get(NewsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        textNews1 = root.findViewById(R.id.textNews1);
        textNews2 = root.findViewById(R.id.textNews3);
        dateNews1 = root.findViewById(R.id.dateNews1);
        dateNews2 = root.findViewById(R.id.dateNews2);
        nameAuthor1 = root.findViewById(R.id.nameAuthor1);
        nameAuthor2 = root.findViewById(R.id.nameAuthor2);

        btnToVotes = root.findViewById(R.id.buttonToVotes);
        btnToVotes.setOnClickListener(listenerToVotes);
        updateInfo();
        return root;
    }

    private void updateInfo() {
        OpenInfoRepo.getSingleton().getAPI().loadInfo()
                .enqueue(new Callback<NewsRequestModel>() {
                    @Override
                    public void onResponse(@NonNull Call<NewsRequestModel> call,
                                           @NonNull Response<NewsRequestModel> response) {
                        if (response.body() != null && response.isSuccessful()) {
                            Toast.makeText(getContext(), "/*Все ок */", Toast.LENGTH_SHORT).show();
                            renderInfo(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsRequestModel> call,
                                          Throwable t) {
                        Toast.makeText(getContext(), "/*Ошибка данных*/", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    View.OnClickListener listenerToVotes = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, VotesFragment.newInstance()).addToBackStack(VotesFragment.class.getName()).commit();
        }
    };

    private void renderInfo(NewsRequestModel model){
        textNews1.setText(model.shortText);
        dateNews1.setText(model.creationDate);
        nameAuthor1.setText(model.authorName);
    }
}