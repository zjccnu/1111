package com.example.administrator.musicproject.service;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcelable;

import com.example.administrator.musicproject.activity.MainActivity;
import com.example.administrator.musicproject.bean.MusicInfo;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class MyService extends Service {
         public  MyBind myBind=null;
         public static  final  String MODULE="memorythedata";
         public class  MyBind extends Binder{
         public   MediaPlayer mp=null;
         public List<MusicInfo> pathlist;
         public int position;
         public  void play(){
            Gson gson=new Gson();
            SharedPreferences sharedPreferences=getSharedPreferences(MODULE,MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            int currenttime=sharedPreferences.getInt("currenttime",0);
            if(gson.toJson(pathlist.get(position)).equals(sharedPreferences.getString("curerntmusic",""))&&
            gson.toJson(pathlist).equals(sharedPreferences.getString("currentlist","") )){
                if(mp==null)
                    mp=new MediaPlayer();
                try {
                    SendMyBraostCast(MainActivity.play,position, true);
                    mp.reset();
                    mp.setDataSource(pathlist.get(position).data);
                    mp.prepare();
                    mp.seekTo(currenttime);
                    mp.start();
                  //  Log.d("xxx","here is shaerparefence");
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(mp==null){
                mp=new MediaPlayer();
            }
            if(mp.isPlaying()){
                mp.reset();
                mp=null;
            }
            if(mp==null){
                mp=new MediaPlayer();
            }
            try {
                SendMyBraostCast(MainActivity.play,position, true);
                mp.reset();
                mp.setDataSource(pathlist.get(position).data);
                mp.prepare();
                mp.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void SendMyBraostCast(String s,int position,Boolean b) {
            Intent intent=new Intent(s);
            intent.putParcelableArrayListExtra("musicinfo", (ArrayList<? extends Parcelable>) pathlist);
            intent.putExtra("boolen", b);
            intent.putExtra("position",position);
            sendBroadcast(intent);
        }

        public void pause(){
            Gson gson=new Gson();
            SharedPreferences sharedPreferences=getSharedPreferences(MODULE,MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("currentlist",gson.toJson(pathlist));
            editor.putString("curerntmusic",gson.toJson(pathlist.get(position)));
            editor.putInt("currenttime", mp.getCurrentPosition());
            editor.commit();
            SendMyBraostCast(MainActivity.pause, position,false);
            mp.pause();
        }

        public void playNext(){
            if(position==pathlist.size()-1)
            {
                position=0;
            }else{
                position=position+1;
            }
            play();
        }
      public void CompleteMusic(){
          mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
              @Override
              public void onCompletion(MediaPlayer mp) {
                  myBind.playNext();
              }
          });

      }
        public int  GetMillionTime(){

            return mp.getCurrentPosition();
        }
        public  int GetTotleTime(){
            return pathlist.get(position).duration;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       /* throw new UnsupportedOperationException("Not yet implemented");*/
        if(myBind==null) {
            myBind = new MyBind();
        }
        return myBind;
    }
}
