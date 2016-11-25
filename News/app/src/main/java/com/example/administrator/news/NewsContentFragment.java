package com.example.administrator.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/25.
 */
public class NewsContentFragment extends Fragment{

    private View view;
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        view=inflater.inflate(R.layout.news_count_frag,container,false);
        return view;
    }
    public void refresh(String newstitle,String newsContent){
        View visibilityLayout=view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newstitltText =(TextView) view.findViewById(R.id.news_title);
        TextView newsContentText=(TextView)view.findViewById(R.id.news_content);
        newstitltText.setText(newstitle);
        newsContentText.setText(newsContent);
    }
}
