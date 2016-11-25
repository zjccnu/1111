package com.example.administrator.homework1.mvp.view.impl;

import com.example.administrator.homework1.mvp.view.MvpView;

/**请求数据，刷新UI界面(标准)---loading页
 * Created by Administrator on 2016/5/27.
 */

public interface MvpLceView<M> extends MvpView {
    //监听加载的视图
public  void showLoading(boolean pullToRefresh);
    //显示内容
    public void showContent();
    //加载错误
    public  void showError(Exception e,boolean pullToRefresh);
    //
    public  void showData(M data);
}
