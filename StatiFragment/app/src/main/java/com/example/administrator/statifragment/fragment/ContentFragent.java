package com.example.administrator.statifragment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.statifragment.MainActivity;
import com.example.administrator.statifragment.R;
import com.example.administrator.statifragment.been.Aticle;
import com.example.administrator.statifragment.been.Been;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragent extends Fragment implements  MainActivity.PostDataToFragment {
 TextView tv;
    public ContentFragent() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_content_fragent, container, false);
        tv= (TextView) view.findViewById(R.id.tvt);
        tv.setText(Been.PrepareData().get(0).getContent());
        return view;
    }

    @Override
    public void PostToFragment(Aticle aticle) {
        tv.setText(aticle.getContent());
    }
}
