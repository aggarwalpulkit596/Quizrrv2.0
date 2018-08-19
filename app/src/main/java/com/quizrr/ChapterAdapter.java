package com.quizrr;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
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
                .inflate(R.layout.chapter_single_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GradientDrawable gradientDrawable;
        if (0 == 0) {
            gradientDrawable = new GradientDrawable(
                    GradientDrawable.Orientation.BOTTOM_TOP, //set a gradient direction
                    new int[]{0xFFffa885, 0xFFff758c}); //set the color of gradient
            holder.chapterBtn.setBackground(gradientDrawable);
        }
        final Chapter ch = chapterArrayList.get(position);
        holder.message.setText(ch.getName());
        holder.name.setText(ch.getQuizes() + "");

        holder.itemView.setOnClickListener(v -> {
            Intent subject = new Intent(mContext, ChapterActivity.class);
            subject.putExtra("chapterId", ch.getId());
            mContext.startActivity(subject);
        });

    }

    @Override
    public int getItemCount() {
        return chapterArrayList.size();
    }
}
