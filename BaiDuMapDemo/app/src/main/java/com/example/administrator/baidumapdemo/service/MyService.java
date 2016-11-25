package com.example.administrator.baidumapdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/8/30.
 */
public class MyService  extends Service{

    private int contentLength;
    private int totalSize;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("xxx","onbind");
     MyBinder myBinder=new MyBinder(this);
        return myBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("xxx","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        Log.d("xxx","onDestroy");
        super.onDestroy();
    }


    @Override
    public void onCreate() {
        Log.d("xxx","onCreate");
       // Log.d("xxx","我是服务线程"+Thread.currentThread().getName());

        super.onCreate();
    }


   public   class MyBinder extends Binder {
        private   MyService myService;
       public MyBinder(MyService myService) {
       this.myService=myService;
       }

       public void startDownload() {
            Log.d("TAG", "startDownload() executed");
            // 执行具体的下载任务
            Log.d("xxx","DownLoad");
        }
       public int getTotalContentLength() {
           return this.myService.contentLength;
       }

       public int getContentProgress() {
           return  this.myService.totalSize;
       }
       




   }

}
