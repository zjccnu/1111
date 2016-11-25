package com.example.administrator.volleydemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
//volley框架的样例  http://1029457926.iteye.com/blog/2203653
public class MainActivity extends AppCompatActivity {
  Button bt;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   //     getSupportActionBar().hide();
 //       getSupportActionBar().hide();
        bt= (Button) findViewById(R.id.bt);
        image= (ImageView) findViewById(R.id.image);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="http://www.baidu.com/";
                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainActivity.this,"no",Toast.LENGTH_SHORT).show();
                    }
                });
                queue.add(stringRequest);
            }
        });

        String url ="http://i.imgur.com/7spzG.png";
        ImageRequest request =new ImageRequest(url,
                new Response.Listener<Bitmap>(){
            @Override
            public void onResponse(Bitmap bitmap){
                Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
                image.setImageBitmap(bitmap);
            }
        },0,0,null,new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){
/*mImageView
.setImageResource(R.drawable.image_load_error);*/
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(request);
    }


}

