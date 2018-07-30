package com.quizrr;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<Chapter> chapterArrayList;
    Context mContext;

    public ChapterAdapter(ArrayList<Chapter> chapterArrayList, Context mContext) {
        this.chapterArrayList = chapterArrayList;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trendinglayout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Chapter ch = chapterArrayList.get(position);
        holder.message.setText(ch.getName());
        holder.name.setText(ch.getQuizes() + "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent subject = new Intent(mContext, ChapterActivity.class);
                subject.putExtra("chapterId", ch.getId());
                mContext.startActivity(subject);
            }
        });

    }

    @Override
    public int getItemCount() {
        return chapterArrayList.size();
    }
}
