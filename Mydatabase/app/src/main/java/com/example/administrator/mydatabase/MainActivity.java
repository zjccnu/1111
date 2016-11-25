package com.example.administrator.mydatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mydatabase.database.Mysqlitedatebase;

public class MainActivity extends AppCompatActivity {

    protected   Mysqlitedatebase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inint();
    }

    private void inint() {
       db=new Mysqlitedatebase(this,"us.db",null,1);
        Button button= (Button) findViewById(R.id.press);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.getWritableDatabase();
            }
        });


    }
}
