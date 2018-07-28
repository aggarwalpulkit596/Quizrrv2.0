package com.quizrr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    }
}
