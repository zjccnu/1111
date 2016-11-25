package com.tz.abiguime.basicsclass.project.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.tz.abiguime.basicsclass.project.R;
import com.tz.abiguime.basicsclass.project.bean.AlbumInfo;
import com.tz.abiguime.basicsclass.project.bean.ArtistInfo;
import com.tz.abiguime.basicsclass.project.bean.MusicInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by abiguime on 2016/9/10.
 */

public class MainHomeFragment extends Fragment {

    private static final String ID = "ID";

    public static MainHomeFragment newInstance(/*int position*/) {

        Bundle args = new Bundle();
//        args.putInt(ID, position);
        MainHomeFragment fragment = new MainHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    int[] img_res_id = {
            R.mipmap.icon_local_music,
            R.mipmap.icon_favorites,
            R.mipmap.icon_folder_plus,
            R.mipmap.icon_artist_plus,
            R.mipmap.icon_album_plus,
            R.mipmap.icon_exit,
    };

    int[] menu_res_id = {
            R.string.my_music,
            R.string.loved_one,
            R.string.direct,
            R.string.artists,
            R.string.albums,
            R.string.network_music
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.mainhome_fragment, container, false);

        /*获取activity中的数据*/

        GridView gridview = (GridView) rootview.findViewById(R.id.gridview);

        Object[] menu_count = {
                ((MainHomeFragment.MainHomeInterface)rootview.getContext()).getMusicInfo().size(),
                0,
                0,
                ((MainHomeFragment.MainHomeInterface)rootview.getContext()).getArtistInfo().size(),
                ((MainHomeFragment.MainHomeInterface)rootview.getContext()).getAlbumInfo().size(),
                0
        };

        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < menu_res_id.length; i++) {
            Map<String, Object> mp = new HashMap<>();
            mp.put("image", img_res_id[i]);
            mp.put("count", menu_count[i]);
            mp.put("desc", getContext().getResources().getString(menu_res_id[i]));
            data.add(mp);
        }

        SimpleAdapter adapter = new SimpleAdapter(rootview.getContext(),
                data,
                R.layout.main_home_gridview_item,
                new String[]{"image", "desc", "count"},
                new int[]{R.id.img_pic, R.id.tv_desc, R.id.tv_count});

        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    /* 我的音乐 */
                    ((MainHomeInterface)getActivity()).OnMyMusicPressed();
                }
            }
        });
        return rootview;
    }


    public interface MainHomeInterface {

        /*获取数据方法*/
        public List<MusicInfo> getMusicInfo();
        public List<ArtistInfo> getArtistInfo();
        public List<AlbumInfo> getAlbumInfo();

        /*调用方法*/
        public void OnMyMusicPressed ();

    }

}
