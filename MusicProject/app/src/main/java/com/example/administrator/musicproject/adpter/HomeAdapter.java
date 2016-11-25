package com.example.administrator.musicproject.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.musicproject.bean.MusicInfo;
import com.example.administrator.musicproject.fragment.FavoriteFragment;
import com.example.administrator.musicproject.fragment.HomeFragment;

import java.util.List;
import java.util.Map;
/**
 * Created by Administrator on 2016/9/13.
 */
public class HomeAdapter extends FragmentPagerAdapter {
    List<MusicInfo> list;
    List<MusicInfo> favorite;
    Map<Integer,Fragment> map;
    public HomeAdapter(FragmentManager fm,Map<Integer,Fragment> map,List<MusicInfo> list,List<MusicInfo> favorite) {
        super(fm);
        this.list=list;
        this.favorite=favorite;
        this.map=map;
    }
    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
         switch (position){
             case 0:if(map.get(position)==null)
                 map.put(position, HomeFragment.newInstance());
                 break;
             case 1:if(map.get(position)==null)
                 map.put(position, FavoriteFragment.newInstance(list,favorite));
                 break;
             case 2:if(map.get(position)==null)
                 map.put(position, FavoriteFragment.newInstance(list, favorite));
                 break;
         }
        return  map.get(position);
    }
    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return map.size();
    }
}
