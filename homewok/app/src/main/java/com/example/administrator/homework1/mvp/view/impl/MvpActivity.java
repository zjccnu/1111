package com.example.administrator.homework1.mvp.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.homework1.mvp.presenter.impl.MvpBasePresent;
import com.example.administrator.homework1.mvp.view.MvpView;

/**
 * 将MVP架构集成到我们的ACtivity
 * Created by Administrator on 2016/5/27.
 */
public abstract class MvpActivity<P extends MvpBasePresent> extends AppCompatActivity implements MvpView{
   protected P presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=bindPresenter();
        if(presenter!=null){
            presenter.attachView(this);
        }
    }

    public abstract  P bindPresenter();
    protected  void onDestroy(){
        super.onDestroy();
        if(presenter!=null)
            presenter.detachView();
    }

}
