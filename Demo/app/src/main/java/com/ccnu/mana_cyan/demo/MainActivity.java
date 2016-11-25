package com.ccnu.mana_cyan.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnImage1 = null;
    private Button btnImage2 = null;
    private Button btnImage3 = null;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
        setOnClickListeners();
    }

    private void getView() {
        btnImage1 = (Button)findViewById(R.id.btn_image_1);
        btnImage2 = (Button)findViewById(R.id.btn_image_2);
        btnImage3 = (Button)findViewById(R.id.btn_image_3);
        image = (ImageView)findViewById(R.id.image);
    }

    private void setOnClickListeners() {

        btnImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.od);
            }
        });

        btnImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.malygos);
            }
        });

        btnImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.velen);
            }
        });

    }

}
