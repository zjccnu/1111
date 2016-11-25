package com.example.administrator.myhard16626;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.list_item);
        ImageAdapter imageAdapter=new ImageAdapter(this,0);
        listView.setAdapter(imageAdapter);
    }
}
