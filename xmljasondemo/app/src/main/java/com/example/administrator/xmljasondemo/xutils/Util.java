package com.example.administrator.xmljasondemo.xutils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/27.
 */
public class Util {
    public Util() {
    }
   public   String   DoPost(String ur1l){
        try {
            URL url=new URL(ur1l);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Charset", "utf-8");
            if(conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "UTF-8"));
                StringBuffer sb = new StringBuffer();
                String readLine=new String();
                while ((readLine = reader.readLine())!= null) {
                    sb.append(readLine).append("\n");
                }
                return sb.toString();
            }
            return  null;
   } catch(Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

}
