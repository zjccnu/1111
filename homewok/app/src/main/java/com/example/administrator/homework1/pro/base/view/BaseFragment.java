package com.example.administrator.homework1.pro.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.homework1.mvp.presenter.impl.MvpBasePresent;
import com.example.administrator.homework1.mvp.view.impl.MvpFragment;

/**
 * Created by Administrator on 2016/5/27.
 */
public abstract class BaseFragment<P extends MvpBasePresent> extends MvpFragment<P> {
    private  View viewcontent;
    @Nullable//缓存视图
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(viewcontent==null) {
            viewcontent = inflater.inflate(getContentView(), container, false);
            initContentView(viewcontent);
        }
        ViewGroup parent=(ViewGroup)viewcontent.getParent();
        if(parent!=null)
        {
            //如果存在就干掉重新添加
            parent.removeView(viewcontent);
        }

    return  viewcontent;
    }
    public P bindPresenter(){
        return  null;
    }
    public  abstract  int getContentView();
    public  abstract  void initContentView(View viewContent);
}
