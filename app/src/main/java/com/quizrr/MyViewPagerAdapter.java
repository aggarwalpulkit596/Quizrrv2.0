package com.quizrr;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

class MyViewPagerAdapter extends PagerAdapter {

    private List<String> data;
    private Context ctx;

    public MyViewPagerAdapter(Context ctx, List<String> data) {
        this.ctx = ctx;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object instantiateItem(View collection, int position) {
        TextView view = new TextView(ctx);
        view.setText(data.get(position));
        ((ViewPager) collection).addView(view);
        return view;
//        View v = LayoutInflater.from()
    }

    @Override
    public void destroyItem(View collection, int position, Object view) {
        ((ViewPager) collection).removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public void startUpdate(View arg0) {
    }

    @Override
    public void finishUpdate(View arg0) {
    }
}
