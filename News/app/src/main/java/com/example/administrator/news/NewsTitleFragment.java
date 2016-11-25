package com.example.administrator.news;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class NewsTitleFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {
    private ListView newsTitleListView;
    private List<New> newslist;
    private  NewsAdapter adapter;
    //String TAG="11";


    @Override
    public void onAttach(Context context) {
        context=this.getActivity();
        super.onAttach(context);
        getNews();

        adapter=new NewsAdapter(context,R.layout.new_item,newslist);
        Log.i("TAG", "onAttach: ");
    }

  public  View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
      View view=inflater.inflate(R.layout.news_title_frag,container,false);
      newsTitleListView=(ListView)view.findViewById(R.id.news_title_list_view);
      newsTitleListView.setAdapter(adapter);
      newsTitleListView.setOnItemClickListener(this);
      Log.i("TAG", "onCreateView ");
      return  view;
  }
public void onActivityCreated(Bundle savedInstanceState){
    super.onActivityCreated(savedInstanceState);
}
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        New news=newslist.get(position);
        //添加监听机制，当点击标题时就会跳转到NewsContentActivity然后调用actionstart方法
        NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());

    }
    /*这是不该出现的错误，这样的返回值怎么可能被接受呢？？
   private List<New> getNews(){
        List<New> newsList=new ArrayList<New>();
        New news1=new New();
        news1.setTitle("Succeed inConnleg");
        news1.setContent("sfdsfsahfhsdlfslkad");
        newslist.add(news1);
        New news2=new New();
        news2.setTitle("Succeed inConnleg");
        news2.setContent("sfdsfsahfhsdlfslkad");
        newslist.add(news2);
        return newsList;
    }*/

    private void getNews(){
        newslist=new ArrayList<New>();
        New news1=new New();
        news1.setTitle("Succeed inConnleg");
        news1.setContent("sfdsfsahfhsdlfslkad");
        newslist.add(news1);
        New news2=new New();
        news2.setTitle("Succeed inConnleg");
        news2.setContent("sfdsfsahfhsdlfslkad");
        newslist.add(news2);

    }
}
