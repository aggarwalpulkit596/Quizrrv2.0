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

public class LearnAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Learn> learnArrayList;
    private Context mContext;

    public LearnAdapter(ArrayList<Learn> learnArrayList, Context mContext) {
        this.learnArrayList = learnArrayList;
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
        GradientDrawable gradientDrawable;
        if (position == 0) {
            gradientDrawable = new GradientDrawable(
                    GradientDrawable.Orientation.BOTTOM_TOP, //set a gradient direction
                    new int[]{0xFFffa885, 0xFFff758c}); //set the color of gradient
            gradientDrawable.setCornerRadius(6f); //set corner radius
        } else if (position == 1) {
            gradientDrawable = new GradientDrawable(
                    GradientDrawable.Orientation.BOTTOM_TOP, //set a gradient direction
                    new int[]{0xFFc0afff, 0xFF7181ff}); //set the color of gradient
            gradientDrawable.setCornerRadius(6f); //set corner radius
        } else if (position == 2) {
            gradientDrawable = new GradientDrawable(
                    GradientDrawable.Orientation.BOTTOM_TOP, //set a gradient direction
                    new int[]{0xFF4cceff, 0xFF4c9ae8}); //set the color of gradient
            gradientDrawable.setCornerRadius(6f); //set corner radius
        } else {
            gradientDrawable = new GradientDrawable(
                    GradientDrawable.Orientation.BOTTOM_TOP, //set a gradient direction
                    new int[]{0xFFffa885, 0xFFff758c}); //set the color of gradient
            gradientDrawable.setCornerRadius(6f); //set corner radius
        }

        final Learn l = learnArrayList.get(position);
        holder.cardBackground.setBackground(gradientDrawable);
        holder.message.setText(l.getName());
        holder.name.setText(l.getChapters().size() + "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent subject = new Intent(mContext, SubjectActivity.class);
                subject.putExtra("subjectId", l.getId());
                mContext.startActivity(subject);
            }
        });

    }

    @Override
    public int getItemCount() {
        return learnArrayList.size();
    }

}
