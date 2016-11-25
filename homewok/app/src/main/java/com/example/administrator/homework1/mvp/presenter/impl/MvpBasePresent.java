package com.example.administrator.homework1.mvp.presenter.impl;

import com.example.administrator.homework1.mvp.presenter.MvpPresenter;
import com.example.administrator.homework1.mvp.view.MvpView;

/**
 * Created by Administrator on 2016/5/27.
 */
public abstract class MvpBasePresent<V extends MvpView>  implements MvpPresenter<V> {
    //绑定View
    private  V view;
    public void attachView(V view){
  this.view=view;
    }
    //解除绑定
    public void detachView(){
        if(view!=null)
            view=null;

    }

}
