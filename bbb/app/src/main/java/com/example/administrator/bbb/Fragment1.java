package com.example.administrator.bbb;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
      return inflater.inflate(R.layout.tab1,container,false);
    }
}
