package com.example.administrator.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2016/8/25.
 */
public class mybracast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("我是广播1", "接到广播" + intent.getStringExtra("msg"));
        //Log.d("我是广播2", "接到广播" + intent.getAction());
        /*if(intent.getAction().equals("")) {
            Log.d("我是广播", "接到广播" + intent.getStringExtra("mag"));
        }else {
            Log.d("11","222");
        }*/
    }
}
