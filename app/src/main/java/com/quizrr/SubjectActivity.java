package com.quizrr;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubjectActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {


    //    @BindView(R.id.backButton)
//    ImageButton backButton;
//    @BindView(R.id.filterButton)
//    ImageButton filterButton;
//    @BindView(R.id.searchButton)
//    ImageButton searchButton;
//    @BindView(R.id.titleTextView)
//    TextView titleTextView;
//    @BindView(R.id.chaptersTextView)
//    TextView chaptersTextView;
//    @BindView(R.id.quizzesTextView)
//    TextView quizzesTextView;
//    @BindView(R.id.accuracytextView)
//    TextView accuracytextView;
//    @BindView(R.id.accuracyPercentagetextView)
//    TextView accuracyPercentagetextView;
//    @BindView(R.id.quiztextView)
//    TextView quiztextView;
//    @BindView(R.id.quizPercentagetextView)
//    TextView quizPercentagetextView;
//    @BindView(R.id.ranktextView)
//    TextView ranktextView;
//    @BindView(R.id.rankPercentagetextView)
//    TextView rankPercentagetextView;
//    @BindView(R.id.recommendationCardTitle)
//    TextView continueCardTitle;
//    @BindView(R.id.chaptersRecyclerViewTitle)
//    TextView chaptersRecyclerViewTitle;
    @BindView(R.id.chaptersRecyclerView)
    RecyclerView chaptersRecyclerView;
//    @BindView(R.id.continueCardLayout)
//    CardView continueCardLayout;

    String subjectId, subjectName;
    private ArrayList<Chapter> chapterList = new ArrayList<>();
    ChapterAdapter chapterAdapter;

    private static final int PERCENTAGE_TO_SHOW_IMAGE = 50;
    private View mFab;
    private int mMaxScrollSize;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_subject);
        ButterKnife.bind(this);
        Intent i = getIntent();

        //Back Button
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        subjectId = i.getStringExtra("subjectId");
        subjectName = i.getStringExtra("name");
        GradientDrawable gradientDrawable;
        if (subjectName.equalsIgnoreCase("Physics")) {
            gradientDrawable = new GradientDrawable(
                    GradientDrawable.Orientation.BOTTOM_TOP, //set a gradient direction
                    new int[]{0xFFffa885, 0xFFff758c}); //set the color of gradient
        } else if (subjectName.equalsIgnoreCase("Math")) {
            gradientDrawable = new GradientDrawable(
                    GradientDrawable.Orientation.BOTTOM_TOP, //set a gradient direction
                    new int[]{0xFFc0afff, 0xFF7181ff}); //set the color of gradient

        } else if (subjectName.equalsIgnoreCase("Chemistry")) {
            gradientDrawable = new GradientDrawable(
                    GradientDrawable.Orientation.BOTTOM_TOP, //set a gradient direction
                    new int[]{0xFF4cceff, 0xFF4c9ae8}); //set the color of gradient
        } else {
            gradientDrawable = new GradientDrawable(
                    GradientDrawable.Orientation.BOTTOM_TOP, //set a gradient direction
                    new int[]{0xFFffa885, 0xFFff758c}); //set the color of gradient
        }
        gradientDrawable.setCornerRadius(6f); //set corner radius
        collapsingToolbarLayout.setBackground(gradientDrawable);
        init();
    }


    private void init() {
        Intent i = getIntent();
        subjectId = i.getStringExtra("subjectId");
        mFab = findViewById(R.id.aboutBar);

        chapterAdapter = new ChapterAdapter(chapterList, getApplicationContext());
        AppBarLayout appbar = findViewById(R.id.app_bar);

        appbar.addOnOffsetChangedListener(this);
        chaptersRecyclerView.setHasFixedSize(true);
        chaptersRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
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
//                    chaptersRecyclerView.smoothScrollToPosition(0);
                    chapterAdapter.notifyDataSetChanged();
                    if (chapterList.size() == 0) {
//                        chaptersRecyclerViewTitle.setVisibility(View.GONE);
                    }
//                    titleTextView.setText(subject.getName());
//                    chaptersTextView.setText(subject.getChapterCount()+" Chapters");
                }

            }

            @Override
            public void onFailure(Call<Subject> call, Throwable t) {

            }
        });
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int currentScrollPercentage = (Math.abs(i)) * 100
                / mMaxScrollSize;

        if (currentScrollPercentage >= PERCENTAGE_TO_SHOW_IMAGE) {
            ViewCompat.animate(mFab).scaleY(0).scaleX(0).start();
//            if (!mIsImageHidden) {
//                mIsImageHidden = true;
//
//
//            }
        }

        if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE) {
            ViewCompat.animate(mFab).scaleY(1).scaleX(1).start();
//            if (mIsImageHidden) {
//                mIsImageHidden = false;
//
//            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_subject_options_menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnCloseListener(() -> {
            return false;
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {

                return true;
            }
        });
        return true;
    }
}
