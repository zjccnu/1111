package com.example.administrator.homework1.mvp.presenter;

import com.example.administrator.homework1.mvp.view.MvpView;

/**
 * Created by Administrator on 2016/5/27.
 */
public interface MvpPresenter<V extends MvpView> {
    //绑定View
    public void attachView(V view);
    //解除绑定
    public void detachView();
}
