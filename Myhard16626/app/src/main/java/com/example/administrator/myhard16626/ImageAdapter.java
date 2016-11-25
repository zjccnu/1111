package com.example.administrator.myhard16626;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/26.
 */
public class ImageAdapter extends ArrayAdapter{
    //图片缓存技术的核心类
    private LruCache<String,BitmapDrawable> mLuCache;
    public ImageAdapter(Context context, int resource,String[] imgeyrls) {
        super(context, resource);
        //获取应用程序最大的可用内存
        int maxmemory= (int) Runtime.getRuntime().maxMemory();
        int cachsize=maxmemory/8;
        mLuCache=new LruCache<String,BitmapDrawable>(cachsize){
            protected int sizeOf(Object key,BitmapDrawable bitmapDrawable) {
                return bitmapDrawable.getBitmap().getByteCount();
            }
        };
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //得到图片的URL
        String url= (String) getItem(position);
        View view;
        if(convertView!=null){
            view= LayoutInflater.from(getContext()).inflate(R.layout.image,null);
        }
        else {
            view=convertView;
        }
        ImageView image= (ImageView) view.findViewById(R.id.image);
        //拿到图片再设置图片
        //先从缓存里面拿，在从SK卡里拿，重新加载
        BitmapDrawable drawable=getBitmapfromMemoryCache(url);
        if(drawable!=null){
            image.setImageDrawable(drawable);
        }else {//开启异步任务下载图片
            BitmapWorkTask task=new BitmapWorkTask(image);
            task.execute(url);
        }
        

        return super.getView(position, convertView, parent);
    }

    private BitmapDrawable getBitmapfromMemoryCache(String url) {
        return mLuCache.get(url);
    }
}
