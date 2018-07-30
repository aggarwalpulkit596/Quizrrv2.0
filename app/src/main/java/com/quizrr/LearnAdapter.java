package com.quizrr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.MyViewHolder> {

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

        Learn l = learnArrayList.get(position);
        holder.message.setText(l.getName());
        holder.name.setText(l.getChapters().size()+"");

    }

    @Override
    public int getItemCount() {
        return learnArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView message, name;

        MyViewHolder(View view) {
            super(view);
            message = view.findViewById(R.id.textView);
            name = view.findViewById(R.id.textView2);


        }
    }
}
