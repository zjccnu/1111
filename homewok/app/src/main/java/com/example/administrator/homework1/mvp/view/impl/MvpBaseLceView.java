package com.example.administrator.homework1.mvp.view.impl;

/**
 * Created by Administrator on 2016/5/27.
 */
public abstract class MvpBaseLceView<M> implements MvpLceView<M> {

@Override
    public void showError(Exception e, boolean pullToRefresh) {

    }

    @Override
    public void showData(M data) {

    }

    @Override
    public void showLoading(boolean pullToRefresh) {

    }

    @Override
    public void showContent() {

    }
}
