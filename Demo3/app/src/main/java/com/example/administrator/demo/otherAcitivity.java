package com.example.administrator.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class otherAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_acitivity);
        TextView textView= (TextView) findViewById(R.id.text);
     /*   Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("bundle");
        UserBean stu= bundle.getParcelable("stu");
        String string=stu.getName();
        int age=stu.getAge();
        Toast.makeText(otherAcitivity.this,"我的年龄:"+age,Toast.LENGTH_SHORT).show();
        if(string!=null)
        textView.setText(string);*/
        String text=textView.getText().toString();
        Toast.makeText(otherAcitivity.this, "我的年龄:" +text, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("text", text);
         setResult(RESULT_OK,intent);

      //  finish();
    }

}
