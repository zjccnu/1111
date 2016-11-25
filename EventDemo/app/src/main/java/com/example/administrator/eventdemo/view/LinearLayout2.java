package com.example.administrator.eventdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/10/19.
 */
public class LinearLayout2 extends LinearLayout {

    public LinearLayout2(Context context, AttributeSet attrs) {
        super(context, null);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("xxx", "Linearout2->dispatchToucEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("xxx", "Linearout2->onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("xxx", "Linearout2->onTouchEvent");
        return super.onTouchEvent(event);
    }
}
