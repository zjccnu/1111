package com.example.administrator.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Administrator on 2016/5/25.
 */
public class NewsContentActivity extends FragmentActivity{
  public static void actionStart(Context context,String newstitle,String newsContent){
      Intent intent=new Intent(context,NewsContentActivity.class);
      intent.putExtra("news_title",newstitle);
      intent.putExtra("news_content",newsContent);
      context.startActivity(intent);

  }
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        String newsTitle=getIntent().getStringExtra("news_title");
        String newsContent=getIntent().getStringExtra("news_content");
      //  NewsContentFragment newsContentFragment = (NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
        NewsContentFragment newsContentFragment = (NewsContentFragment)getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle,newsContent);

    }
}
