package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.VideoView;


public class Image_fragment extends Fragment {
   VideoView videoView=null;
    private static final String TAG = "adsfdsafsadfsdafsdf";

    public static Image_fragment newInstance(int imageresouse) {

        Bundle args = new Bundle();
        args.putInt(TAG,imageresouse);
        Image_fragment fragment = new Image_fragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_image_fragment,container,false);
        LinearLayout ly= (LinearLayout) view.findViewById(R.id.layout);
        videoView= (VideoView) view.findViewById(R.id.videoview);
        int image=getArguments().getInt(TAG);
        ly.setBackgroundResource(image);

        return view;
    }


}
