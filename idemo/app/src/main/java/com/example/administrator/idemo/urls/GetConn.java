package com.example.administrator.idemo.urls;

import android.content.Context;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

/**
 *
 * Created by Administrator on 2016/8/20.
 *
 */
public class GetConn {
    private static final int MESSSAGE_SUCCESS = 1;
    private static final int MESSAGE_FAIL = 2;

    String  httpurl;
    URL url;
    String bf;
    Context mcontext;
   // Handler handler;
    InputStream inputStream;
    Map<String,String> map;
    StringBuilder stringBuilder;
    /*
    public GetConn(String httpurl,Context context,Map<String,String> map,Handler handler){
         Looper.prepare();
         this.httpurl=httpurl;
          mcontext=context;
         this.map=map;
         this.handler=handler;
    }


  public void  DoGet() {
        try {
            //URL进行交互
            stringBuilder=new StringBuilder(httpurl);
            stringBuilder.append("?");
            for (String key:map.keySet()
                    ) {
                stringBuilder.append(key+"="+map.get(key)+"&");
            }
             stringBuilder.deleteCharAt(stringBuilder.length()-1);
             httpurl=stringBuilder.toString();
             url=new URL(httpurl);
            Log.d("aaaaa",httpurl);
             HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferread=new BufferedReader(new InputStreamReader(inputStream));
                bf=bufferread.readLine();
          //      Log.d("xxxx",bf+"111");
                //不懂这里为什么不能toast
                Message msg=Message.obtain();
                if(bf.equals("成功")) {
                    msg.what=MESSSAGE_SUCCESS;
                }else{
                    msg.what=MESSAGE_FAIL;
                }
                msg.obj=bf;
                Bundle bundle=new Bundle();
                bundle.putString("result",bf);
                msg.setData(bundle);
        //        handler.sendMessage(msg);
          //      Log.d("xxxx",bf+"222");
              mt("成功");
            }
            else{

                mt("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//post请求的请求思路:只不过后面的参数不能通过URL进行传递，用输出流传给服务器，其他方式基本上一样。
    public void  DoPost() {
        byte[] bytes;
        try {
            //URL进行交互
            url=new URL(httpurl);
            stringBuilder=new StringBuilder();

            for (String key:map.keySet()
                    ) {
                stringBuilder.append(key+"="+map.get(key)+"&");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            httpurl=stringBuilder.toString();
            bytes=httpurl.getBytes();
            Log.d("地址", httpurl);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            OutputStream outputStream= httpURLConnection.getOutputStream();
            outputStream.write(bytes, 0, bytes.length);
            outputStream.close();
            if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferread=new BufferedReader(new InputStreamReader(inputStream));
                bf=bufferread.readLine();
                //不懂这里为什么不能toast,子线程要开启一个消息队列才能Toast
               //   mt("成功");
                Log.d("返回的数据为",bf+"1111");
            }
            else{
               Log.d("返回的数据为",bf+"1111");
   //             mt("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




public void mt(String mess) {
  //非UI线程Toast需要加上这2句话
      Looper.prepare();
      Toast.makeText(mcontext,mess,Toast.LENGTH_LONG).show();
      Looper.loop();
  }


*/


    public static void Dopost2(File file,String CHARSET,String httpurl1){
        String  result = null;
        String  BOUNDARY =  UUID.randomUUID().toString();  //边界标识   随机生成
        String  PREFIX = "--" ;
        String  LINE_END = "\r\n";
        String  CONTENT_TYPE = "multipart/form-data";   //内容类型
        try {
            URL url=new URL(httpurl1);
            Log.d("我是服务器url",httpurl1);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();

               //首先设定服务器参数包括:请求方法,时延,是否允许输入输出流等等
            conn.setRequestMethod("POST");

           conn.setDoInput(true);
            conn.setDoOutput(true);
         /*   conn.setConnectTimeout(5000);*/
         Log.d("我是服务器返回码","我是返回码"+conn.getResponseCode());
            //就按照表单上传文件的方式去拼接一下参数
            if(conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
                DataOutputStream out = new DataOutputStream(conn.getOutputStream());

                conn.setRequestProperty("Charset", CHARSET);  //设置编码
                conn.setRequestProperty("connection", "keep-alive");
                conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
                if (file != null) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(PREFIX);
                    sb.append(BOUNDARY);
                    sb.append(LINE_END);
                    /**
                     * 这里重点注意：
                     * name里面的值为服务器端需要key   只有这个key 才可以得到对应的文件
                     * filename是文件的名字，包含后缀名的   比如:abc.png
                     */
                    sb.append("Content-Disposition: form-data; name=\"upfile\"; filename=\"" + file.getName() + "\"" + LINE_END);
                    sb.append("Content-Type: application/octet-stream; charset=" + CHARSET + LINE_END);
                    sb.append(LINE_END);
                    out.write(sb.toString().getBytes());
                    Log.d("aaaaaaa", "我为空123");
                    FileInputStream in = new FileInputStream(file);
                    byte[] bytes = new byte[4048];
                    if (in.read(bytes) != -1) {
                        out.write(bytes);
                        Log.d("aaaaaaa","我不为空");
                        Log.d("dsfsda",new String(bytes)+"12e312");
                    }
                    Log.d("aaaaaaa","我为空");
                    out.write(LINE_END.getBytes());
                    byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
                    out.write(end_data);
                    out.flush();
                    out.close();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }








}
