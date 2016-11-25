package com.example.administrator.definelistdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.definelistdemo.been.fruitbeen;
import com.example.administrator.definelistdemo.defineadpter.adpter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listview;
    List<fruitbeen> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview= (ListView) findViewById(R.id.list);
        init();
        adpter adpte=new adpter(getBaseContext(),data);
        listview.setAdapter(adpte);
        listview.setOnItemClickListener(this);
    }

    private void init() {
        data=new ArrayList<>();
        fruitbeen fruit=new fruitbeen();
        fruit.setName("西瓜1");
        fruit.setFruitId(R.drawable.ip);
        data.add(fruit);
        fruitbeen fruit1=new fruitbeen();
        fruit1.setName("西瓜2");
        fruit1.setFruitId(R.drawable.ip);
        data.add(fruit1);
        fruitbeen fruit2=new fruitbeen();
        fruit2.setName("西瓜3");
        fruit2.setFruitId(R.drawable.ip);
        data.add(fruit2);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        fruitbeen fruit=data.get(position);
        Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
    }
}
