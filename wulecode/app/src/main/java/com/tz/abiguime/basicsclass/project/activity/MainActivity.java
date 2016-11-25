package com.tz.abiguime.basicsclass.project.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.tz.abiguime.basicsclass.project.R;
import com.tz.abiguime.basicsclass.project.bean.AlbumInfo;
import com.tz.abiguime.basicsclass.project.bean.ArtistInfo;
import com.tz.abiguime.basicsclass.project.bean.MusicInfo;
import com.tz.abiguime.basicsclass.project.fragments.MainHomeFragment;
import com.tz.abiguime.basicsclass.project.fragments.MenuFragment;
import com.tz.abiguime.basicsclass.project.fragments.MusicListFragment;
import com.tz.abiguime.basicsclass.project.fragments.TestFragment;
import com.tz.abiguime.basicsclass.project.fragments.intrf.ActivityToMusicListFrgInterface;
import com.tz.abiguime.basicsclass.project.fragments.intrf.MusicFragmentInteface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends SlidingFragmentActivity implements MenuFragment.MenuOnclick,
        MainHomeFragment.MainHomeInterface, MusicFragmentInteface{


    private static final int PROP_NUMB = 5;
    private ViewPager viewpager;


    List<MusicInfo> musicInfoList;
    List<ArtistInfo> artistInfoList;
    List<AlbumInfo> albumInfoList;
    private MainViewPagerAdapter adaap;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.right_menu); /*菜单内容*/
//        getSlidingMenu().setMode(SlidingMenu.RIGHT); /*设置边栏方向 左右*/
//        getSlidingMenu().setBehindOffsetRes(R.dimen.slidingmenu_offset);  /*设置左右剩下空间*/

        getSlidingMenu().setTouchModeAbove(View.FOCUSABLES_TOUCH_MODE);//全屏
        //设置侧边栏的位置：右边
        getSlidingMenu().setMode(SlidingMenu.RIGHT);
        //设置预留的屏幕宽度
        getSlidingMenu().setBehindOffset(200);

        /*设置边栏菜单*/
        initMenu();
        initMainView();
    }


    private void initMainView() {

/* public static final String MY_ARTIST_TAG = "MY_ARTIST_TAG" ;
    public static final String MY_ALBUM_TAG = "MY_ALBUM_TAG" ;*/

        /*从引导页获取数据*/
        // 1- 音乐列表
        musicInfoList = getIntent().getParcelableArrayListExtra(SplashActivity.MY_MUSIC_TAG);
        // 2- 歌手信息列表
        artistInfoList = getIntent().getParcelableArrayListExtra(SplashActivity.MY_ARTIST_TAG);
        // 3- 专辑列表
        albumInfoList = getIntent().getParcelableArrayListExtra(SplashActivity.MY_ALBUM_TAG);

        viewpager = (ViewPager) findViewById(R.id.viewpager);
        adaap = new MainViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adaap);
    }


    private void initMenu() {

        /*将framelayout添加右侧栏。。。*/
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.add(R.id.menu_frame, MenuFragment.newInstance(), MenuFragment.MENU_TAG);
        trans.commit();
    }


    @Override
    public void menuClick(int i) {
        /**/
        mT("点击—— "+getResources().getString(menu_res_id[i]));
    }

    private void mT(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


    int[] menu_res_id = {
            R.string.scan,
            R.string.repeat_mode,
            R.string.change_bg,
            R.string.alarm,
            R.string.settings,
            R.string.exit,
    };

    @Override
    public List<MusicInfo> getMusicInfo() {
        return musicInfoList;
    }

    @Override
    public List<ArtistInfo> getArtistInfo() {
        return artistInfoList;
    }

    @Override
    public List<AlbumInfo> getAlbumInfo() {
        return albumInfoList;
    }

    @Override
    public void OnMyMusicPressed() {
            /*切换fragment
            * 1- 把数据创给fragment、
            * 2- 再切换fragment */
        MusicListFragment frg = (MusicListFragment) adaap.getItem(MainViewPagerAdapter.POSITION_1_MUSICLIST);
        mT("切换了");
        frg.updateData(getMusicInfo());
        // 等500毫秒再切换fragment
        viewpager.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        viewpager.setCurrentItem(MainViewPagerAdapter.POSITION_1_MUSICLIST);
                    }
                });
            }
        }, 500);

    }

    // 媒体播放对象
    MediaPlayer mp;

    // 正在播放的媒体并媒体在列表中的id。
    int cPosition = -1;
    List<MusicInfo> cInfo = null;

    @Override
    public void play(int position, List<MusicInfo> infList) {
        // 播放音乐.
        if (mp == null) {
            mp = new MediaPlayer();
        } else {
            mp.stop();
            mp.release();
            mp = null;
            play(position, infList);
            return;
           /*  mp.reset();*/
        }
        MusicInfo inf = infList.get(position);
        try {
            // 设置音乐
            mp.setDataSource(inf.data);
            // 缓存媒体文件
            mp.prepare();
            // 播放当前音乐.
            mp.start();
            cPosition = position;
            cInfo = infList;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mp != null && mp.isPlaying())
            mp.stop();
    }

    public class MainViewPagerAdapter extends FragmentPagerAdapter {

        public static final int POSITION_0_HOME = 0, POSITION_1_MUSICLIST = 1, POSITION_2_XXX = 2;

        public MainViewPagerAdapter(FragmentManager fm) {
            super(fm);
            frg = new HashMap<>();
        }

        Map<Integer, Fragment> frg;

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0: /*显示主页面*/
                    if (frg.get(position)  == null) {
                        frg.put(position, MainHomeFragment.newInstance());
                    }
                    break;
                case 1: /*显示音乐列表*/
                    if (frg.get(position)  == null) {
                        frg.put(position, MusicListFragment.newInstance(new ArrayList<MusicInfo>()));
                    }
                    break;
                case 2: /*显示歌手。。。*/
                    if (frg.get(position)  == null) {
                        frg.put(position, TestFragment.newInstance(position));
                    }
                    break;
            }
            return frg.get(position);
        }

        @Override
        public int getCount() {
            return PROP_NUMB;
        }
    }

}
