package com.quizrr;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import carbon.widget.Button;
import carbon.widget.FrameLayout;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView message, name;
    public FrameLayout cardBackground;
    public Button chapterBtn;

    MyViewHolder(View view) {
        super(view);
        message = view.findViewById(R.id.textView);
        name = view.findViewById(R.id.textView2);
        cardBackground = view.findViewById(R.id.cardBackground);
        chapterBtn = view.findViewById(R.id.chapterBtn);


    }
}
