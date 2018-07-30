package com.quizrr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubjectActivity extends AppCompatActivity {

    @BindView(R.id.backButton)
    ImageButton backButton;
    @BindView(R.id.filterButton)
    ImageButton filterButton;
    @BindView(R.id.searchButton)
    ImageButton searchButton;
    @BindView(R.id.titleTextView)
    TextView titleTextView;
    @BindView(R.id.chaptersTextView)
    TextView chaptersTextView;
    @BindView(R.id.quizzesTextView)
    TextView quizzesTextView;
    @BindView(R.id.accuracytextView)
    TextView accuracytextView;
    @BindView(R.id.accuracyPercentagetextView)
    TextView accuracyPercentagetextView;
    @BindView(R.id.quiztextView)
    TextView quiztextView;
    @BindView(R.id.quizPercentagetextView)
    TextView quizPercentagetextView;
    @BindView(R.id.ranktextView)
    TextView ranktextView;
    @BindView(R.id.rankPercentagetextView)
    TextView rankPercentagetextView;
    @BindView(R.id.recommendationCardTitle)
    TextView continueCardTitle;
    @BindView(R.id.chaptersRecyclerViewTitle)
    TextView chaptersRecyclerViewTitle;
    @BindView(R.id.chaptersRecyclerView)
    RecyclerView chaptersRecyclerView;
    @BindView(R.id.continueCardLayout)
    CardView continueCardLayout;

    String subjectId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        ButterKnife.bind(this);
        Intent i = getIntent();
        subjectId = i.getStringExtra("subjectId");
        init();
        getSubject();
    }

    private void getSubject() {
    }

    private void init() {
        Intent i = getIntent();
        subjectId = i.getStringExtra("subjectId");
    }

}
