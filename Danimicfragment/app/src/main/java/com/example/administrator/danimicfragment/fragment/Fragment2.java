package com.example.administrator.danimicfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.danimicfragment.R;

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_fragment2,container,false);
        return view;
    }
}
