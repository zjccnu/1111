package com.example.administrator.videoviewdemo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import java.io.File;
import java.io.FileInputStream;
public class MainActivity extends AppCompatActivity {
VideoView videoView;
    File f=null;
    File ff=null;
    Button bt;
    private MediaController mController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView= (VideoView) findViewById(R.id.videoview);
        bt= (Button) findViewById(R.id.bt);
       Log.d("xxx1",Environment.getExternalStorageState());
        Log.d("xxx2", Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.d("xxx4",Environment.getDataDirectory().getAbsolutePath());
        Log.d("xxx5",Environment.getRootDirectory().getAbsolutePath());
        Log.d("xxx6",Environment.getDownloadCacheDirectory().getAbsolutePath());
        mController=new MediaController(MainActivity.this);
        mController.setMediaPlayer(videoView);
        Log.d("xxx", Environment.getRootDirectory().getAbsolutePath());
        Log.d("xx", Environment.getExternalStorageDirectory().getAbsolutePath());

        try {
            File file=new  File( "/mnt/shell/emulated/0/Download/other/222.txt");
            Log.d("xxx","我在这里还没异常1");
           FileInputStream in=new FileInputStream(file);

            byte[] bytes=new byte[2024];
            Log.d("x我读到的数据是xx",""+in.read());
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("xxx","我一场了");
        }

      /*   File file=new  File( "/mnt/shell/emulated/0/Download/other/weibo.mp4");
         Log.d("xxx",file.getAbsolutePath());

           videoView.setVideoPath(file.getAbsolutePath());
            videoView.setMediaController(mController);
            videoView.requestFocus();
           videoView.start();*/

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {

                        /*try {

                            FileInputStream in=new FileInputStream(ff);
                            Log.d("xxx", Environment.getExternalStorageDirectory().getAbsolutePath());
                            f =new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/zhou");
                            if(!f.exists()){
                                f.mkdirs();
                                Log.d("xxx","sfdsfsdfdsfsdfdsfsdfd");
                            }
                            FileOutputStream out=new FileOutputStream(f);
                            byte[]  by=new byte[2048];
                            while (in.read(by)!=-1){
                                out.write(by);
                            }
                            in.close();
                            out.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d("xxx","我异常了");
                        }*/

                    }
                }).start();


            }
        });

    }
}
