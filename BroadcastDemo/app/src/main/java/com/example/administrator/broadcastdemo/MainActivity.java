package com.example.administrator.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt;
    BroadcastReceiver rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //动态注册广播
        rec=new mybracast();
        IntentFilter filter=new IntentFilter();
        //添加所接受广播的频率
        filter.addAction("android.intent.action.MY_BROADCAST");
        filter.setPriority(Integer.MAX_VALUE);
        registerReceiver(rec,filter);
    }

    public void initView() {
        bt= (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置广播的频率
                Intent intent = new Intent("android.intent.action.MY_BROADCAST");
                intent.putExtra("msg", "hello receiver.");

                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(rec);
    }
}
