package com.example.administrator.musicproject.activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.musicproject.R;
import com.example.administrator.musicproject.bean.AlbumInfo;
import com.example.administrator.musicproject.bean.ArtistInfo;
import com.example.administrator.musicproject.bean.MusicInfo;
import com.example.administrator.musicproject.db.MusicDao;
import com.example.administrator.musicproject.utils.AlbumUtils;
import com.example.administrator.musicproject.utils.ArtistUtils;
import com.example.administrator.musicproject.utils.MusicUtils;
import java.util.ArrayList;
import java.util.List;
public class SplashActivity extends AppCompatActivity {
    private static final long WAIT_TI =3000 ;
    private Handler handler=new Handler();
    public static final String MY_MUSIC_TAG = "MY_MUSIC_TAG" ;
    public static final String MY_ARTIST_TAG = "MY_ARTIST_TAG" ;
    public static final String MY_ALBUM_TAG = "MY_ALBUM_TAG" ;
    public static  final  String MY_FAVORITE_TAG="MY_FAVORITE_TAG";
     //构造方法的问题
        @Override
        public void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_spalsh);
            //开始时间
             Long time=System.currentTimeMillis();
            requestPermissions();
        }
    // 权限获取好之后，要进行的方法
    private void afterHavingPermission () {
        // 获取操作开始的时间
        long time = System.currentTimeMillis();

        /*获取、
        *        - 我的音乐，专辑，文件夹。。。  媒体内容提供者*/
        // 获取我的音乐列表
       final List<MusicInfo> musicList = MusicUtils.querySystemMusic(this);
        final List<AlbumInfo> albumList = AlbumUtils.querySystemAlbums(this);
        final List<ArtistInfo> artistList = ArtistUtils.querySystemAlbums(this);
        final List<MusicInfo> farvorite= MusicDao.queryLocalMusic(this);

         long finaltime = (System.currentTimeMillis()); /*操作完成时间*/
        /* 3000.。。*/
         /*过一段时间调到mainactivity里去*/
         handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.putParcelableArrayListExtra(MY_MUSIC_TAG, (ArrayList<? extends Parcelable>) musicList);
                intent.putParcelableArrayListExtra(MY_ARTIST_TAG, (ArrayList<? extends Parcelable>) artistList);
                intent.putParcelableArrayListExtra(MY_ALBUM_TAG, (ArrayList<? extends Parcelable>)  albumList);
                intent.putParcelableArrayListExtra(MY_FAVORITE_TAG, (ArrayList<? extends Parcelable>) farvorite);
                startActivity(intent); /* 调到 主页去 */
                overridePendingTransition(R.anim.home_enter, R.anim.splash_exit);
                finish();  /* 毁灭当前activity */
            }
        }, finaltime - time > WAIT_TI ? 0 : (WAIT_TI- (finaltime-time)));
    }
    private static String PERMISSION_READ_EXT = "android.permission.READ_EXTERNAL_STORAGE";
    private static String PERMISSION_WRITE_EXT = "android.permission.WRITE_EXTERNAL_STORAGE";
    public void requestPermissions() {
        // PERMISSION 权限字符串 android.permission.WRITE_EXTERNAL_STORAGE
        int hasPermission_read = ContextCompat.checkSelfPermission(SplashActivity.this, PERMISSION_READ_EXT);
        int hasPermission_write = ContextCompat.checkSelfPermission(SplashActivity.this, PERMISSION_WRITE_EXT);
        if (hasPermission_read == PackageManager.PERMISSION_GRANTED) {
            /*权限已经有了*/
            afterHavingPermission();
        } else {
             /*还没有权限，需要获取*/
            if (ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this, PERMISSION_READ_EXT)
                    ) {
                afterHavingPermission();
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                /* 向系统获取persmission里的权限*/
                ActivityCompat.requestPermissions(SplashActivity.this,
                        new String[]{
                                PERMISSION_READ_EXT},
                        REQUEST_FILES_PERMISSIONS);
            }
        }
    }

    private static final int REQUEST_FILES_PERMISSIONS = 56; /* 获取权限回调代码 */
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_FILES_PERMISSIONS: {
                if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mT("权限获取成功");
                    afterHavingPermission();
                } else {
                    mT("权限获取失败");
                }
                return;
            }
        }
    }

    private void mT(String message) {
        Toast.makeText(SplashActivity.this, message, Toast.LENGTH_SHORT).show();
    }

}


