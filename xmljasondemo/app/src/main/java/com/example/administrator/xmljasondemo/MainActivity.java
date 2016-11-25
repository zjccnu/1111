package com.example.administrator.xmljasondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.xmljasondemo.xmlparse.XMLParse;
import com.example.administrator.xmljasondemo.xutils.Util;

public class MainActivity extends AppCompatActivity {
    Button bt;
   public  static final String url="http://192.168.1.100:8088/androidtest/xml.php";
    public static  final  String url1="http://192.168.1.100:8088/androidtest/json.php";
    public  static final String url2="http://192.168.1.100:8088/androidtest/xmldemo.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt= (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       Util util=new Util();
                    //   Log.d("xxx", util.DoPost(url));
                        XMLParse parse=new XMLParse(util.DoPost(url2));
                       parse.toXML();
                   //    JsonParse jsonParse=new JsonParse();
                    //    jsonParse.parseJson(util.DoPost(url1));
                  //      jsonParse.parseJsonbyGson(util.DoPost(url1));
                    }
                }).start();

            }
        });

    }
}
