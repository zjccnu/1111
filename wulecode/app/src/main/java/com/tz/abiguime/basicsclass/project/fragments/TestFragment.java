package com.tz.abiguime.basicsclass.project.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tz.abiguime.basicsclass.project.R;

/**
 * Created by abiguime on 2016/9/10.
 */

public class TestFragment extends Fragment {

    private static final String ID = "ID";

    public static TestFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt(ID, position);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.test_fragment, container, false);

        TextView view = (TextView) rootview.findViewById(R.id.tv);
        view.setText("第一 == "+getArguments().getInt(ID));
        return rootview;
    }
}
