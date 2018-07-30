package com.quizrr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private ArrayList<Chapter> chapterList = new ArrayList<>();
    ChapterAdapter chapterAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        ButterKnife.bind(this);
        Intent i = getIntent();
        subjectId = i.getStringExtra("subjectId");
        init();
    }


    private void init() {
        Intent i = getIntent();
        subjectId = i.getStringExtra("subjectId");
        chapterAdapter = new ChapterAdapter(chapterList, getApplicationContext());
        chaptersRecyclerView.setHasFixedSize(true);
        chaptersRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        chaptersRecyclerView.setAdapter(chapterAdapter);
        getSubject();

    }

    private void getSubject() {
        ApiInterface apiService = ApiClients.getClient().create(ApiInterface.class);
        Call<Subject> call = apiService.subject("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1YWRjYTBiN2ZhN2ZkYzMxOWY2MjkzMTkiLCJ1c2VybmFtZSI6Inlhc2h0aGFrb3IiLCJpYXQiOjE1MzI5Mjg4MDgsImV4cCI6MTU2NDQ2NDgwOH0.EWDIuJIC0fVBee712ng_s4z3f5rVv_bTh676whj6aWg", subjectId);
        call.enqueue(new Callback<Subject>() {
            @Override
            public void onResponse(Call<Subject> call, Response<Subject> response) {
                if (response.isSuccessful()) {
                    Subject subject = response.body();
                    chapterList.addAll(subject.getChapters());
                    chaptersRecyclerView.smoothScrollToPosition(0);
                    chapterAdapter.notifyDataSetChanged();
                    if (chapterList.size() == 0) {
                        chaptersRecyclerViewTitle.setVisibility(View.GONE);
                    }
                    titleTextView.setText(subject.getName());
                    chaptersTextView.setText(subject.getChapterCount()+" Chapters");
                }

            }

            @Override
            public void onFailure(Call<Subject> call, Throwable t) {

            }
        });
    }


}
