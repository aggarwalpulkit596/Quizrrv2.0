package com.quizrr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.notificationImageView)
    ImageButton notificationImageView;
    @BindView(R.id.logoImageView)
    ImageView logoImageView;
    @BindView(R.id.livequizRecyclerView)
    RecyclerView livequizRecyclerView;

    @BindView(R.id.learnLayout)
    RelativeLayout learnLayout;
    @BindView(R.id.learnRecyclerViewTitle)
    TextView learnRecyclerViewTitle;
    @BindView(R.id.learnRecyclerView)
    RecyclerView learnRecyclerView;
    private ArrayList<Learn> learnList = new ArrayList<>();
    LearnAdapter learnAdapter;


    @BindView(R.id.trendingLayout)
    RelativeLayout trendingLayout;
    @BindView(R.id.trendingRecyclerViewTitle)
    TextView trendingRecyclerViewTitle;
    @BindView(R.id.trendingRecyclerView)
    RecyclerView trendingRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        init();
        getLearn();
    }

    private void init() {
        //learn Layout
        learnAdapter = new LearnAdapter(learnList, getApplicationContext());
        learnRecyclerView.setHasFixedSize(true);
        learnRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        learnRecyclerView.setAdapter(learnAdapter);

    }

    private void getLearn() {
        ApiInterface apiService = ApiClients.getClient().create(ApiInterface.class);
        Call<List<Learn>> call = apiService.learn("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1YWRjYTBiN2ZhN2ZkYzMxOWY2MjkzMTkiLCJ1c2VybmFtZSI6Inlhc2h0aGFrb3IiLCJpYXQiOjE1MzI5Mjg4MDgsImV4cCI6MTU2NDQ2NDgwOH0.EWDIuJIC0fVBee712ng_s4z3f5rVv_bTh676whj6aWg");
        call.enqueue(new Callback<List<Learn>>() {
            @Override
            public void onResponse(Call<List<Learn>> call, Response<List<Learn>> response) {
                if (response.isSuccessful()) {
                    List<Learn> list1 = response.body();
                    learnList.addAll(list1);
                    learnRecyclerView.smoothScrollToPosition(0);
                    learnAdapter.notifyDataSetChanged();
                    if (learnList.size() == 0) {
                        learnLayout.setVisibility(View.GONE);

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Learn>> call, Throwable t) {

            }
        });
    }
}
