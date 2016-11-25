package com.example.administrator.musicproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.administrator.musicproject.R;
import com.example.administrator.musicproject.adpter.GirdAdpter;
import com.example.administrator.musicproject.bean.GirdItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<GirdItem> data;
    GridView girdView;
    GirdAdpter adpter;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
             View view=inflater.inflate(R.layout.fragment_home, container, false);
             girdView= (GridView) view.findViewById(R.id.gridview);
             initData();
            adpter=new GirdAdpter(getContext(),data);
            girdView.setAdapter(adpter);
           girdView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   HomeFragment.FragmentToActivity c=(HomeFragment.FragmentToActivity)getActivity();
                   c.loaction(position);
                   Log.d("xxx","我点击了"+position);
               }
           });
           return view;
    }

    public  interface  FragmentToActivity{
        public void loaction(int position);
    }
    private void initData() {

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
        data = new ArrayList<GirdItem>();
        for (int i = 0; i < menu_res_id.length; i++) {
            GirdItem item = new GirdItem();
            item.setImage(img_res_id[i]);
            item.setText(menu_res_id[i]);
            data.add(item);
        }
    }

}
