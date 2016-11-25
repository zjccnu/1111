package com.example.administrator.xmljasondemo.jsonparse;

import android.util.Log;

import com.example.administrator.xmljasondemo.URLbeen.Indentify;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/8/27.
 */
public class JsonParse {
  //将字符串转化为json对象
     public void  parseJson(String JsonString){
         try {
             JSONObject json=new JSONObject(JsonString);
            Log.d("xxx", json.getJSONObject("address").getString("city"));
             Log.d("xxx", json.getString("firstName"));
             JSONArray array=json.getJSONArray("phoneNumbers");
             for(int i=0;i<array.length();i++){
                 JSONObject object= (JSONObject) array.get(i);
                  Log.d("xxx",object.getString("type"));
             }
         } catch (Exception e){
             e.printStackTrace();
         }

     }
    //Gson来解析最简单
    public void parseJsonbyGson(String JsonString){
        Gson gson=new Gson();
        Indentify indentify=gson.fromJson(JsonString,Indentify.class);
        Log.d("xxx",indentify.firstName);
        Log.d("xxx",indentify.phoneNumbers[0].number);
    }

}
