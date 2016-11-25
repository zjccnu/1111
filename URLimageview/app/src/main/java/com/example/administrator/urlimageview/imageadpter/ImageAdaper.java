package com.example.administrator.urlimageview.imageadpter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.administrator.urlimageview.R;
import com.example.administrator.urlimageview.been.ImageBeen;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by Administrator on 2016/8/23.
 */
public class ImageAdaper extends BaseAdapter {
    ListView mlistview;
    String[] stings;
    LruCache<String,BitmapDrawable> mlrucache;
    Context context;
   public   ImageAdaper(Context context){
       //设置LruCache的最大缓存
       int maxMemory= (int) Runtime.getRuntime().maxMemory();
       int cacheSize=maxMemory/8;
       mlrucache=new LruCache<String,BitmapDrawable>(cacheSize){
           @Override
           //获取每个图片的大小
           protected int sizeOf(String key, BitmapDrawable drawable) {
            //   return super.sizeOf(key, bitmap);
               return drawable.getBitmap().getByteCount();

           }
       };
       this.stings= ImageBeen.strings;
       this.context=context;
   }
    @Override
    public int getCount() {
        return stings.length;
    }


    @Override
    public Object getItem(int position) {
        return stings[position];
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(mlistview==null){
            mlistview= (ListView) parent;
        }
     if(convertView==null){

         ViewHolder viewHolder=new ViewHolder();
         convertView=LayoutInflater.from(context).inflate(R.layout.item,null);
         viewHolder.textView= (TextView) convertView.findViewById(R.id.text2);
         viewHolder.imageView= (ImageView) convertView.findViewById(R.id.image);
   //       Log.d("xxx",stings[position]+"我是周健");
            convertView.setTag(viewHolder);
     }else{
         ViewHolder viewHolder= (ViewHolder) convertView.getTag();
         viewHolder.textView.setText("图片" + position);
         BitmapDrawable  drawable=getBitMapfromCache(stings[position]);
         //从缓存中去拿

         if(drawable!=null) {
             viewHolder.imageView.setImageBitmap(drawable.getBitmap());
         }else{
             //需要在异步任务中去更新UI
             viewHolder.imageView.setImageResource(R.drawable.aa);
             //不需要传viewHolder.imageView了，通过setTag去拿对应的imageview就好，防止图片错位
             viewHolder.imageView.setTag(stings[position]);
          //   ImageTakeTask task=new ImageTakeTask(viewHolder.imageView);
             ImageTakeTask task=new ImageTakeTask();
             task.execute(stings[position]);
         }
     }
        return convertView;
    }

    private BitmapDrawable getBitMapfromCache(String sting) {
        return  mlrucache.get(sting);
    }
    public class  ViewHolder{
        TextView textView;
        ImageView imageView;
    }

    public  class   ImageTakeTask extends AsyncTask<String ,Integer,Bitmap>{

   //     ImageView imageView;
   //     public ImageTakeTask(ImageView imageView){
    //        this.imageView=imageView;
     //   }
        String url=null;
        @Override
        protected Bitmap doInBackground(String... params) {
            BitmapDrawable drawable=null;
            Bitmap bitmap=null;
            HttpURLConnection conn=null;

            url =params[0];
           // Log.d("参数", url+"213123");
            try {
                URL url1=new URL(url);
                conn = (HttpURLConnection) url1.openConnection();
               Log.d("aaaaaaa", String.valueOf(conn.getResponseCode()) + "我是周健");
                bitmap= BitmapFactory.decodeStream(conn.getInputStream());
                BitmapDrawable drawable1=new BitmapDrawable(bitmap);
                //把下载下来的图片加入缓存中
                Log.d("21",url+"1111");
                addBitMapToLuCache(url, drawable);

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(conn!=null)
                conn.disconnect();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
           // super.onPostExecute(bitmap);
            ImageView  imageView= (ImageView) mlistview.findViewWithTag(url);
            //这个条件必须写，因为异步加载可能图片为空
            if(imageView!=null&&bitmap!=null) {
                imageView.setImageBitmap(bitmap);
            }

        }

        public void addBitMapToLuCache(String url,BitmapDrawable drawable){
            mlrucache.put(url,drawable);
        }
    }

}
