package com.example.administrator.interdemo.urls;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/20.
 */
public class GetConn  {
    String  httpurl;
    URL url;
    String bf;
    InputStream inputStream;
    public GetConn(String httpurl){
        this.httpurl=httpurl;
        CreateConnect();
    }

  public void CreateConnect() {
        try {
            url=new URL(httpurl);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(3000);
            if(httpURLConnection.getResponseCode()==httpURLConnection.HTTP_OK){
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferread=new BufferedReader(new InputStreamReader(inputStream));
                   bf=bufferread.readLine();
                Log.d("xxxx",bf);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
