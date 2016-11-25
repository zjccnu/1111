package com.example.administrator.musicproject.activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.musicproject.R;
import com.example.administrator.musicproject.adpter.HomeAdapter;
import com.example.administrator.musicproject.bean.AlbumInfo;
import com.example.administrator.musicproject.bean.ArtistInfo;
import com.example.administrator.musicproject.bean.MusicInfo;
import com.example.administrator.musicproject.fragment.FavoriteFragment;
import com.example.administrator.musicproject.fragment.HomeFragment;
import com.example.administrator.musicproject.fragment.MusicFragment;
import com.example.administrator.musicproject.fragment.SildeFragment;
import com.example.administrator.musicproject.service.MyService;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MainActivity extends SlidingFragmentActivity implements  SildeFragment.SetOnMenuClick ,HomeFragment.FragmentToActivity,MusicFragment.MusicFragmentToActivity,FavoriteFragment.MusicFragmentToActivity {
    public final static String play = "com.example.administrator.play";
    public final static String pause = "com.example.administrator.pause";
    public FragmentTransaction tran;
    public final static String TAG = "woshiyige";
    public ViewPager pager;
    public Map<Integer, Fragment> map;
    public HomeAdapter adapter;
    public List<MusicInfo> musicList;
    public List<AlbumInfo> albumList;
    public List<ArtistInfo> artistList;
    public List<MusicInfo> favorite;
    public MediaPlayer mp;
    public TextView text;
    public ImageButton bt, bt2, btnext;
    public MyService.MyBind s;
    public TextView artist, music, time;
    private int position;
    public ProgressBar bar;
    private boolean isplaying;
 /*   private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            int c = (int) msg.obj;
            bar.setMax(c);
            bar.setProgress(s.MillionTime());
            text.setText(MillomToMinnter(s.MillionTime()));
            return false;
        }
    });*/



    @Override
    protected void onStart() {
        super.onStart();
        PlayMusicBroadCast broast = new PlayMusicBroadCast();
        IntentFilter intent = new IntentFilter();
        intent.addAction(play);
        intent.addAction(pause);
        registerReceiver(broast, intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.right_menu); /*菜单内容*/
        //   getSlidingMenu().setMode(SlidingMenu.RIGHT); /*设置边栏方
        // 向 左右*/
        //   getSlidingMenu().setBehindOffsetRes(R.dimen.slidingmenu_offset); /*设置左右剩下空间*/
        getSlidingMenu().setTouchModeAbove(View.FOCUSABLES_TOUCH_MODE);//全屏
        //设置侧边栏的位置：右边
        getSlidingMenu().setMode(SlidingMenu.RIGHT);
        //设置预留的屏幕宽度
        getSlidingMenu().setBehindOffset(250);
        /*设置边栏菜单*/
        GetInfo();
        initMenu();
        initMainView();

    }

    private void GetInfo() {
        Intent intent = getIntent();
        musicList = intent.getParcelableArrayListExtra(SplashActivity.MY_MUSIC_TAG);
        artistList = intent.getParcelableArrayListExtra(SplashActivity.MY_ARTIST_TAG);
        albumList = intent.getParcelableArrayListExtra(SplashActivity.MY_ALBUM_TAG);
        favorite = intent.getParcelableArrayListExtra(SplashActivity.MY_FAVORITE_TAG);
    }

    private void initMainView() {
        bt = (ImageButton) findViewById(R.id.btn_pause2);
        bt2 = (ImageButton) findViewById(R.id.btn_play2);
        artist = (TextView) findViewById(R.id.artist_tv2);
        music = (TextView) findViewById(R.id.musicname_tv2);
        btnext = (ImageButton) findViewById(R.id.btn_playNext2);
        bar = (ProgressBar) findViewById(R.id.playback_seekbar2);
        time = (TextView) findViewById(R.id.duration_tv2);
        text = (TextView) findViewById(R.id.position_tv2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.play();
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.pause();

            }
        });
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                s.playNext();
            }
        });
        map = new HashMap<Integer, Fragment>();
        map.put(0, HomeFragment.newInstance());
        map.put(1, MusicFragment.newInstance(musicList, favorite));
        map.put(2, FavoriteFragment.newInstance(musicList, favorite));
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new HomeAdapter(getSupportFragmentManager(), map, musicList, favorite);
        pager.setAdapter(adapter);
    }

    private void initMenu() {
        tran = getSupportFragmentManager().beginTransaction();
        tran.add(R.id.menu_frame, SildeFragment.newInstance(), TAG);
        tran.commit();
    }

    @Override
    public void OnMenClick(String message) {
        mt(message);
    }

    private void mt(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loaction(int position) {
        //隐藏底部视图
        //     findViewById(R.id.bottomLayout).setVisibility(View.INVISIBLE);
        if (position >= map.size()) {
            pager.setCurrentItem(0);
        } else {
            pager.setCurrentItem(position);
        }
    }

    @Override
    public void playmusic(final int position) {

        this.position = position;
        ServiceConnection conn = null;
        Intent intent = null;
        if (intent == null) {
            intent = new Intent(MainActivity.this, MyService.class);
        }
        if (conn == null) {
            conn = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    Log.d("xx", "我绑定成功了1");
                    s = (MyService.MyBind) service;
                    s.pathlist = musicList;
                    s.position = position;
                    s.play();

                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    Log.d("xx", "对不起我绑定失败了");
                }
            };
        }

        bindService(intent, conn, BIND_AUTO_CREATE);

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                Message ms=Message.obtain();
                ms.obj=musicList.get(position).duration;
                handler.sendMessage(ms);
            }
        }).start();*/

    }

    public Runnable run = new Runnable() {
        @Override
        public void run() {
            Log.d("xxx","我到UI1线程了");
            final int totalDuration = s.GetTotleTime();
            // 当前进度s;
            final int duration = s.GetMillionTime();
            // 媒体总共长度
            while(isplaying){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final int duration = s.GetMillionTime();
                        bar.setMax(totalDuration);
                        bar.setProgress(duration);
                        text.setText(MillomToMinnter(duration));
                        Log.d("xxx", "" + totalDuration);
                        Log.d("xxx", "" + duration);
                        s.CompleteMusic();
                    }
                });
            }

        }
    };

    @Override
    public void playmusict(int position) {
        this.position = position;
        playmusic(position);
    }

    public class PlayMusicBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            List<MusicInfo> musicInfos = intent.getParcelableArrayListExtra("musicinfo");
            boolean B = intent.getBooleanExtra("boolen", false);
            int p=intent.getIntExtra("position", -1);
            if(p!=-1) {
                position = p;
            }
            Log.d("xxx", "" + B);
            updateBottom(musicInfos, B);


        }

        private void updateBottom(List<MusicInfo> musicInfos, boolean p3) {
            artist.setText(musicInfos.get(position).artist);
            music.setText(musicInfos.get(position).musicName);
            time.setText(MillomToMinnter(musicInfos.get(position).duration));
            if (p3) {
                bt2.setVisibility(View.INVISIBLE);
                bt.setVisibility(View.VISIBLE);
                isplaying=true;
            } else {
                bt2.setVisibility(View.VISIBLE);
                bt.setVisibility(View.INVISIBLE);
                isplaying=false;
            }
            (new Thread(run)).start();
        }

        private String MillomToMinnter(int duration) {
            String s = "";
            int minuter = duration / 60000;
            double d = duration * 1.0 / 60000;
            double dd = d - minuter;
            double ddd = dd * 60;
            int m = (int) ddd;
            if (m > 10) {
                return s + minuter + ":" + m;
            } else {
                return s + minuter + ":0" + m;
            }

        }
    }

    private String MillomToMinnter(int duration) {
        String s = "";
        int minuter = duration / 60000;
        double d = duration * 1.0 / 60000;
        double dd = d - minuter;
        double ddd = dd * 60;
        int m = (int) ddd;
        if (m > 10) {
            return s + minuter + ":" + m;
        } else {
            return s + minuter + ":0" + m;
        }
    }
}

