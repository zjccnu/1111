package com.example.administrator.eventdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/19.
 */
public class Text extends TextView {
    public Text(Context context, AttributeSet attrs) {
        super(context, null);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("xxx", "text->dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("xxx", "text->onTouchEvent");
        return super.onTouchEvent(event);
    }
}
