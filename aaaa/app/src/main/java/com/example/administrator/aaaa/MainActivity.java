package com.example.administrator.aaaa;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager mviewpage;
    private LinearLayout s1;
    private LinearLayout s2;
    private LinearLayout s3;
    private LinearLayout s4;
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;
    private PagerAdapter mAdapter;
    private List<View> mviews=new ArrayList<View>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        R
    }
    private void initEvent() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        mviewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
                 int currentItem=mviewpage.getCurrentItem();
                        resetImg();
                       switch(currentItem){
                       case 0:
                           button1.setImageResource(R.drawable.s3);
                       break;
                       case 1:
                       button1.setImageResource(R.drawable.s3);
                       break;
                       case 2:
                       button3.setImageResource(R.drawable.s3);
                       break;
                       case 3:
                       button4.setImageResource(R.drawable.s3);
                      break;
               }
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
    }
    //图片暗量的变化
    public void onClick(View v){
           resetImg();
        switch (v.getId()) {
            case R.id.button1:
                mviewpage.setCurrentItem(0);
                button1.setImageResource(R.drawable.s3);
                break;
            case R.id.button2:
                mviewpage.setCurrentItem(1);
                button2.setImageResource(R.drawable.s3);
                break;
            case R.id.button3:
                mviewpage.setCurrentItem(2);
                button3.setImageResource(R.drawable.s3);
                break;
            case R.id.button4:
                mviewpage.setCurrentItem(3);
                button4.setImageResource(R.drawable.s3);
                break;
        }

    }

    private void resetImg() {
        button1.setImageResource(R.drawable.s1);
        button2.setImageResource(R.drawable.s2);
        button3.setImageResource(R.drawable.s3);
        button4.setImageResource(R.drawable.s4);
    }
    private void initView() {
        mviewpage=(ViewPager)findViewById(R.id.viewpage);
        s1=(LinearLayout)findViewById(R.id.s1);
        s2=(LinearLayout)findViewById(R.id.s2);
        s3=(LinearLayout)findViewById(R.id.s3);
        s4=(LinearLayout)findViewById(R.id.s4);
        button1=(ImageButton)findViewById(R.id.button1);
        button2=(ImageButton)findViewById(R.id.button2);
        button3=(ImageButton)findViewById(R.id.button3);
        button4=(ImageButton)findViewById(R.id.button4);
        LayoutInflater mInflater=LayoutInflater.from(this);
        View tab1=mInflater.inflate(R.layout.tab1, null);
        View tab2=mInflater.inflate(R.layout.tab2,null);
        View tab3=mInflater.inflate(R.layout.tab3,null);
        View tab4=mInflater.inflate(R.layout.tab4,null);
        mviews.add(tab1);
        mviews.add(tab2);
        mviews.add(tab3);
        mviews.add(tab4);
        mAdapter=new PagerAdapter() {
            @Override
            public int getCount() {
                return mviews.size();
            }
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
            public Object instantiateItem(ViewGroup contain,int position){
                contain.addView(mviews.get(position),0);
                return mviews.get(position);
            }
            public void destroyItem(ViewGroup contain,int position,Object object){
                contain.removeView(mviews.get(position));
            }
        };
        mviewpage.setAdapter(mAdapter);

    }
}
