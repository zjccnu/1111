package com.example.administrator.volleydemo.utils;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
/**
 * Created by Administrator on 2016/9/7.
 */
public class Loaders {
     Context context;
     public Loaders(Context context) {
        this.context = context;
    }
    String url="http://www.google.com";
    RequestQueue queue= Volley.newRequestQueue(context);
    StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String s) {
            Toast.makeText(context, "yws", Toast.LENGTH_SHORT).show();
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            Toast.makeText(context, "NO", Toast.LENGTH_SHORT).show();
        }
    });


}
