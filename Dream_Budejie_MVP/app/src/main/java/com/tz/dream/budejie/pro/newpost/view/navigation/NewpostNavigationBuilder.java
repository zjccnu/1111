package com.tz.dream.budejie.pro.newpost.view.navigation;

import android.content.Context;

import com.tz.dream.budejie.R;
import com.tz.dream.budejie.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 * Created by Dream on 16/5/27.
 */
public class NewpostNavigationBuilder extends NavigationBuilderAdapter{

    public NewpostNavigationBuilder(Context context){
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_newpost_layout;
    }
}
