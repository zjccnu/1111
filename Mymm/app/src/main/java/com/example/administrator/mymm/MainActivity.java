package com.example.administrator.mymm;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<String> list=new ArrayList<String>();
    private Spinner myspinner;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ImageButton button1=(ImageButton)findViewById(R.id.button9);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent=new Intent("com.example.activitytest.ACTION_START");
               // intent.setData(Uri.parse("tel:10086"));
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,1);
            }
        });

        list.add("北京");
        list.add("上海");
        list.add("武汉");
        list.add("宜昌");
        myspinner=(Spinner)findViewById(R.id.下拉列表);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(adapter);
        myspinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub


                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });
        myspinner.setOnTouchListener(new Spinner.OnTouchListener() {
            @Override


            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                /**
                 *
                 */
                return false;
            }
        });

        myspinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });

    }


}
