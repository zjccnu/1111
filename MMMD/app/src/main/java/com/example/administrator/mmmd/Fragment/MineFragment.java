package com.example.administrator.mmmd.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mmmd.R;

/**
 * Created by Administrator on 2016/6/7.
 */
public class MineFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_mine,container,false);
        return view;
    }
}
