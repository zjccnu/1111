package com.example.administrator.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
public class NewsAdapter extends ArrayAdapter<New>{
    private int resourceId;


    public NewsAdapter(Context context, int resource, List<New> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }
    public View getView(int position,View convweView,ViewGroup parent) {
        New news = getItem(position);
        View view;
        if (convweView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        } else {
            view = convweView;
        }
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        newsTitleText.setText(news.getTitle());
        return view;
    }
}
