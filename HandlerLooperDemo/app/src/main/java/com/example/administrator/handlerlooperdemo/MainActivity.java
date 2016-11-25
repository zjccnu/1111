package com.example.administrator.handlerlooperdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt1, bt2, bt3, bt4;
    private String TAG = "HandlerTest";
    private boolean bpostRunnable = false;

    private NoLooperThread noLooperThread = null;
  //  private OwnLooperThread ownLooperThread = null;
  //  private ReceiveMessageThread receiveMessageThread =null;

    private Handler  mOtherThreadHandler=null;
 //   private EventHandler mHandler = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);

    }

    class OtherThread extends Thread {
        Handler handler = null;
        String mymsg = null;

        @Override
        public void run() {
            super.run();
            Looper.prepare();
            Looper lp1 = Looper.getMainLooper();
            if (Looper.myLooper() == null) {
                handler = new Handler(Looper.myLooper());
                mymsg = "我不是主线程";
            } else {
                handler = new Handler(lp1);
                mymsg = "我是主线程";
            }
            handler.removeMessages(0);
            Message msg = handler.obtainMessage(3, 1, 1, mymsg);
            handler.sendMessage(msg);
            Looper.loop();
        }
    }

    class NoLooperThread extends Thread {
        Handler mNoLooperThreadHandler=null;
        @Override
        public void run() {

            Looper myLooper = Looper.myLooper();
            Looper mainLooper= Looper.getMainLooper();

            String msgobj;
            if(null == myLooper){
                //这里获得的是主线程的Looper,由于NoLooperThread没有自己的looper所以这里肯定会被执行
                mNoLooperThreadHandler = new Handler(mainLooper);
                msgobj = "NoLooperThread has no looper and handleMessage function executed in main thread!";
            } else{
                mNoLooperThreadHandler = new Handler(myLooper);
                msgobj = "This is from NoLooperThread self and handleMessage function executed in NoLooperThread!";
            }

            mNoLooperThreadHandler.removeMessages(0);

            if(bpostRunnable == false){
                //send message to main thread
                Message msg = mNoLooperThreadHandler.obtainMessage(2, 1, 1, msgobj);
                mNoLooperThreadHandler.sendMessage(msg);
                Log.e(TAG, "NoLooperThread id:--------+>" + this.getId());
            }else{
                //下面new出来的实现了Runnable接口的对象中run函数是在Main Thread中执行，不是在NoLooperThread中执行 记得 null == myLooper么
                //注意Runnable是一个接口，它里面的run函数被执行时不会再新建一个线程
                //您可以在run上加断点然后在eclipse调试中看它在哪个线程中执行

                mNoLooperThreadHandler.post(new Runnable(){
                    public void run() {
                        // TODO Auto-generated method stub
                        //tv.setText("update UI through handler post runnalbe mechanism!");
                        Log.e(TAG, "update UI id:--------+>" + Thread.currentThread().getId());
                        noLooperThread.stop();
                    }

                });
            }
        }

    }
}
