package com.quizrr;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView message, name;

    MyViewHolder(View view) {
        super(view);
        message = view.findViewById(R.id.textView);
        name = view.findViewById(R.id.textView2);


    }
}