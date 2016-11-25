package com.example.administrator.idemo.loadtask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/23.
 */
public class LoadTask extends AsyncTask<String ,Integer,String> {
    public  Context context;
    TextView textView;
    ProgressBar bar;
    public   LoadTask(Context context,TextView textView,ProgressBar bar){
       this.context=context;
        this.textView=textView;
        this.bar=bar;
   }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        bar.setProgress(0);
        Toast.makeText(context,"开始执行",Toast.LENGTH_LONG).show();
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */

    @Override
    protected String doInBackground(String... params) {
        String buffer=null;
        String link=params[0];
        Log.d("xxx", link);
        try {
             URL url=new URL(link);
             HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            if(conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                buffer = new String();
                buffer = reader.readLine();
            }
            else {
                mt("网络请求失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       Log.d("我是异步任务", buffer);
        //很奇怪Toast之后onPostExecute不会执行
   //   mt(buffer);
        publishProgress(100);
        return buffer;
    }
//当异步任务执行结束后执行的方法，s的值为 doInBackground返回的结果
    @Override
    protected void onPostExecute(String s) {
      //  super.onPostExecute(s);
        Log.d("xxx",s);
        textView.setText(s);
        Toast.makeText(context,"执行完毕",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
    //    super.onProgressUpdate(values);
     //   textView.setText(values[0]);
        bar.setProgress(values[0]);
    }

    public void mt(String mess) {
        //非UI线程Toast需要加上这2句话
       // Looper.prepare();
        Toast.makeText(context, mess, Toast.LENGTH_LONG).show();
     //   Looper.loop();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        bar.setProgress(0);
    }
}
