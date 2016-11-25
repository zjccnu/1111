package com.example.administrator.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView tv_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.pressme);
        tv_view= (TextView) findViewById(R.id.text);
        if (button != null) {
            button.setOnClickListener(this);
        }

    }
  public void onClick(View view){
      Intent intent=new Intent(this,otherAcitivity.class);
    /*  UserBean stu=new UserBean();
      stu.setAge(18);
      stu.setName("zj");
      Bundle bundle=new Bundle();
      bundle.putParcelable("stu", stu);
      intent.putExtra("bundle", bundle);*/
  //    startActivity(intent);
      startActivityForResult(intent, 400);
  }

    public void onActivityResult(int requestCode,int resultCode,Intent intent) {
       super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode==400&&resultCode==RESULT_OK) {
            String text = intent.getStringExtra("text");
            Toast.makeText(MainActivity.this, "我的年龄:"+text, Toast.LENGTH_SHORT).show();

        }

    }
}
