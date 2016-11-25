package com.example.administrator.myhard16626;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/6/26.
 */
//第一个请求参数的类型，我们这里传的是url
    //参数二代表任务进度
    //参数三代表返回值，我们需要获取图片1
public class BitmapWorkTask extends AsyncTask<String,Void,BitmapDrawable> {
    private ImageView imageView;
    BitmapWorkTask(ImageView imageView){
        this.imageView=imageView;
    }
    //该方法相当于run方法
    @Override
    protected BitmapDrawable doInBackground(String... params) {
        String imageurl=params[0];
        //根据URL在我们的后台进行下载
        Bitmap bitmap=DownBitmap(imageurl);
        //把bitmap转化为bitmapdrawable
        BitmapDrawable drawable=new BitmapDrawable(getClass().getResource(),bitmap);
        //图片下载成功后存入缓存中
        AddBitmapToMemoryCache(imageurl,drawable);
        return  null;
    }

    private void AddBitmapToMemoryCache(String imageurl, BitmapDrawable drawable) {
        //判断缓存中是否有该图片
        if()
    }

    private Bitmap DownBitmap(String imageurl) {
        Bitmap bitmap=null;
        HttpURLConnection httpURLConnection=null;
        try {
            URL url=new URL(imageurl);
             httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(1000);
            bitmap= BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(httpURLConnection!=null) {
                httpURLConnection.disconnect();
            }
        }

        return bitmap;
    }

}
