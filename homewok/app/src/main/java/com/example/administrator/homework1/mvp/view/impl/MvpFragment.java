package com.example.administrator.homework1.mvp.view.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.administrator.homework1.mvp.presenter.impl.MvpBasePresent;
import com.example.administrator.homework1.mvp.view.MvpView;

/**
 * Created by Administrator on 2016/5/27.
 */
public abstract class MvpFragment<P extends MvpBasePresent> extends Fragment implements MvpView{
  protected  P present;
   @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       present=bindPresenter();
       if(present!=null)
           present.attachView(this);
    }
    public  abstract  P bindPresenter();
    public  void onDestroy(){
        super.onDestroy();
        if(present!=null)
            present.detachView();
    }
}
