package com.example.administrator.newdefinedemo.KateTextView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.administrator.newdefinedemo.R;

/**
 * Created by Administrator on 2016/7/28.
 */
public class KateTextView extends View{
    private String text;
    private int textSize;
    private int textColor;
    public KateTextView(Context context) {
        super(context);
        initAttrs(context,null,-1);
    }



    public KateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context,attrs,-1);

    }

    public KateTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs, defStyleAttr);
    }

    private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
     //获取KateView所有的属性 attrs.xml
        TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.KateTextView);
        text=ta.getString(R.styleable.KateTextView_newText);
        textColor=ta.getColor(R.styleable.KateTextView_newTextColor, Color.RED);
        int defValue= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,12,getResources().getDisplayMetrics());
        textSize= (int) ta.getDimension(R.styleable.KateTextView_newTextSize,defValue);
        ta.recycle();
        ininPaint();

    }
    private Paint mPaint;
    private Rect bounds;
    private void ininPaint() {
        mPaint = new Paint();
        //颜色
        mPaint.setColor(textColor);
        //大小
        mPaint.setTextSize(textSize);
        //抗锯齿
        mPaint.setAntiAlias(true);
        //设置画笔的样式
        mPaint.setStyle(Paint.Style.FILL);
        //拿到文字的大小---矩型
        bounds = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), bounds);

    }
    /**
     * 自定义的控件的宽和高：是通过onMeasure方法 测量出来  问题：wrap_content----宽和高是全屏
     * 宽高的模式：3种
     * AT_MOST  ：wrap_content
     * EXACTLY  :match_parent 或者固定值
     * UNSPECIFIED ：无限大  一般不用
     * widthMeasureSpec :组合值     32位的整数---30位：尺寸   后面2位：模式
     * heightMeasureSpec:组合值
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);//最大值或者固定值
        int mWidth = widthSize;
        if(widthMode == MeasureSpec.AT_MOST){//wrap_content
            mWidth = getPaddingLeft()+getPaddingRight()+bounds.width();//内容的宽度;
        }

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);//最大值或者固定值
        int mHeight = heightSize;
        if(heightMode == MeasureSpec.AT_MOST){//wrap_content
            mHeight = getPaddingBottom()+getPaddingTop()+bounds.height();//内容的宽度;
        }
        setMeasuredDimension(mWidth,mHeight);
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    /**
     * 通过onDraw方法将文字绘制到控件中
     * canvas  ：画布
     *
     * mPrint  : 画笔
     *
     */
    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawText(text,(getWidth()-bounds.width())/2, (getHeight()+bounds.height())/2, mPaint);
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
