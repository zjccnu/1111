package com.example.administrator.listdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.list_item);
        List<Map<String,String>> data=new ArrayList<>();
        Map<String,String> map;
        for (int i=0;i<5;i++){
            map =new HashMap<>();
            map.put("name","1"+i);
            map.put("age","2"+i);
            data.add(map);
        }

        SimpleAdapter adapter=new SimpleAdapter(this,data,R.layout.item,new String[]{"name","age"},new int[]{R.id.tv1,R.id.tv2});
        listView.setAdapter(adapter);
    }

}
