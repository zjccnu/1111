package com.example.administrator.interdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button bt;
    final  static  String url="http://10.146.64.1:8088/androidtest/index.php?username=zhou&password=123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        username=findViewById()
    }
}
