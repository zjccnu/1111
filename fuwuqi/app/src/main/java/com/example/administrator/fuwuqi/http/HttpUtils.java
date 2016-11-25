package com.example.administrator.fuwuqi.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/6/4.
 */
public class HttpUtils {
    public  static String post(String serverUrl,String username,String password) throws IOException {
        //创建请求
        try {
            URL url=new URL(serverUrl);
            HttpURLConnection coon=(HttpURLConnection)url.openConnection();
            coon.setDoInput(true);
            coon.setDoOutput(true);
            coon.setRequestMethod("POST");
            coon.setRequestProperty("Charset", "UTF-8");
            coon.connect();
            StringBuffer params=new StringBuffer();
            params.append("username=");
            params.append(username);
            params.append("&");
            params.append("password=");
            params.append(password);
            DataOutputStream outputStream=new DataOutputStream(coon.getOutputStream());
            outputStream.writeBytes(params.toString());
            outputStream.flush();
            outputStream.close();
            int code= coon.getResponseCode();
            if(code==HttpURLConnection.HTTP_OK){
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(coon.getInputStream(),"UTF-8"));
                params.delete(0,params.length());
                String readline=null;
                while((readline=bufferedReader.readLine())!=null){
                    params.append(readline);

                }
                bufferedReader.close();
                return params.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
