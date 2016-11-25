package com.example.administrator.fuwuqi;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.fuwuqi.http.LoginTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,LoginTask.OnHttpResultListen{
   private EditText text1;
    private EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ininView();
    }
    private  void ininView(){
        text1= (EditText) findViewById(R.id.Edit_text1);
        text2= (EditText) findViewById(R.id.Edit_text2);
        findViewById(R.id.button).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        LoginTask loginTask=new LoginTask(this);
        loginTask.execute(text1.getText().toString(),text2.getText().toString());
    }

    @Override
    public void onResult(String result) {
    if(!TextUtils.isEmpty(result)){
    Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
}   else {
    Toast.makeText(this,"登陆失败",Toast.LENGTH_SHORT).show();
}
    }
}
