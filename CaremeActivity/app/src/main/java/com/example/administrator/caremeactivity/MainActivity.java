package com.example.administrator.caremeactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt= (Button) findViewById(R.id.bt);
        bt.setOnClickListener(this);

    }
    protected void  onActivityResult(int response,int resultCode,Intent intent){
       if(resultCode== Activity.RESULT_OK){
    
       }
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,100);
    }
}
