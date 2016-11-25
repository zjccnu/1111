package com.example.administrator.idemo;

import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.idemo.urls.GetConn;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{
    TextView textView;
    EditText username;
    EditText password;
    ProgressBar bar;
    Button bt;
    Map<String,String> map;
    private static final String FILE_TO_UPLOAD =
            Environment.getExternalStorageDirectory().getAbsolutePath()+"" +
                    "/beautif.gif";

  //  http://localhost:8088/androiddemoMVC/index.php/Admin/Index/index
  //  final  static  String url="http://115.28.72.15:8080/indexget.php";
   final  static String url="http://192.168.1.101:8088/androiddemoMVC/index.php/Admin/Index/index " ;
   /*public Handler handler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           if(msg.what==1){
               mt(msg.getData().getString("result"));
           }else {
               mt(msg.getData().getString("result"));
           }
       }
   };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map=new HashMap<>();
        textView= (TextView) findViewById(R.id.tv);
        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        bar= (ProgressBar) findViewById(R.id.bar);
        bt= (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                map.put("username", username.getText().toString());
                map.put("password", password.getText().toString());
              // onupdate();
                (new Thread(){
                    @Override
                    public void run() {
                        super.run();
                  //      GetConn getConn=new GetConn(url,getApplicationContext(),map,handler);
                 //       getConn.DoGet();
                   //     getConn.DoPost();
                        File file = new File(FILE_TO_UPLOAD);
                        if(file!=null)
                        {
                            GetConn.Dopost2(file,"utf-8",url);
                            Log.d("aaa","文件不为空");
                            mt("文件不为空");

                        }else{
                            mt("文件为空");
                            Log.d("aaa", "文件为空");
                        }

                    }
                }).start();

            }
        });

    }

 /*   private void onupdate() {
        StringBuilder stringBuilder=new StringBuilder(url);
        stringBuilder.append("?");
        for (String key:map.keySet()
                ) {
            stringBuilder.append(key+"="+map.get(key)+"&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        String url1=stringBuilder.toString();
        LoadTask loadTask=new LoadTask(this,textView,bar);
        loadTask.execute(url1);
    }*/

    public void mt(String mess) {
        //非UI线程Toast需要加上这2句话

        Looper.prepare();
        Toast.makeText(this,mess,Toast.LENGTH_LONG).show();
        Looper.loop();

    }



}





