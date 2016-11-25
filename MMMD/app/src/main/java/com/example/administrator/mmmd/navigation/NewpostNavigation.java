package com.example.administrator.mmmd.navigation;

import android.content.Context;

import com.example.administrator.mmmd.R;

/**
 * Created by Administrator on 2016/6/7.
 */
public class NewpostNavigation extends NavigationBuilderAdapter {
    public NewpostNavigation(Context context){
        super(context);
    }
    @Override
    public int getLayoutId() {
        return R.layout.toolbar_newpost_layout;
    }
}
