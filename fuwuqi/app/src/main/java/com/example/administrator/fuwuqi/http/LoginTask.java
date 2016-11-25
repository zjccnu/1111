package com.example.administrator.fuwuqi.http;

import android.os.AsyncTask;

import java.io.IOException;

/**
 * Created by Administrator on 2016/6/4.
 */
//异步任务
public class LoginTask extends AsyncTask<String,Void,String> {

    private  static  final  String URL="http://192.168.56.1:8080/com.tv.zj1/LoginServlet";
    private  OnHttpResultListen onHttpResultListen;

    public LoginTask( OnHttpResultListen onHttpResultListen) {
        this.onHttpResultListen = onHttpResultListen;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            return HttpUtils.post(URL,params[0],params[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
    protected  void onPostExecute(String s){
        if(this.onHttpResultListen!=null){
            this.onHttpResultListen.onResult(s);

        }
    }
    //网络请求成功后回调
    public  interface OnHttpResultListen{
       public void  onResult (String result);
    }
}
