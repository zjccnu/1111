package com.example.administrator.danimicfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.danimicfragment.R;

/**
 * Created by Administrator on 2016/9/4.
 */
public class Fragment1 extends Fragment {
    public static String TAG="safsdfsdfsd";
    //相当于构造方法，可以让activity给Fragment赋值
    public static Fragment1 newInstance(int i) {

        Bundle args = new Bundle();
        args.putInt(TAG,i);
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment1,container,false);
        Toast.makeText(getActivity(),""+ getArguments().getInt(TAG),Toast.LENGTH_SHORT).show();
        return view;
    }
}
