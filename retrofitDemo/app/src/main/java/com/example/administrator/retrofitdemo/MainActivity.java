package com.example.administrator.retrofitdemo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtil.initData(this);
        textview1.setText("woshuzhojian");
    }
}
