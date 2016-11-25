package com.example.administrator.cccc;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private ViewPager mviewpage;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragment;
    private LinearLayout s1;
    private LinearLayout s2;
    private LinearLayout s3;
    private LinearLayout s4;
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;
    private Fragment tab1;
    private Fragment tab2;
    private Fragment tab3;
    private Fragment tab4;

    @Override
    protected  void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
       setSelect(0);

    }

    private void initEvent() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }
    public void onClick(View v){

        switch (v.getId()) {
            case R.id.button1:
                  setSelect(0);
                 break;
            case R.id.button2:
                setSelect(1);
                break;
            case R.id.button3:
                setSelect(2);
                break;
            case R.id.button4:
                setSelect(3);
                break;
        }

    }

    //切换图片至暗色
    private void resetImg() {
        button1.setImageResource(R.drawable.p_1);
        button2.setImageResource(R.drawable.p_2);
        button3.setImageResource(R.drawable.p_3);
        button4.setImageResource(R.drawable.p_4);
    }
    private  void setSelect(int i){
        resetImg();
switch (i){
    case 0:
        button1.setImageResource(R.drawable.p_11);
        break;
    case 1:
        button2.setImageResource(R.drawable.p_2w);
        break;
    case 2:
        button3.setImageResource(R.drawable.p_33);
        break;
    case 3:
        button4.setImageResource(R.drawable.p_44);
        break;
    default:
        break;

}
        mviewpage.setCurrentItem(i);
        //设置监听事件，当滑动屏幕时，底下的图标也相应发生改变
        mviewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                int currentItem=mviewpage.getCurrentItem();
                switch (currentItem){
                    case 0:
                        button1.setImageResource(R.drawable.s2);
                        break;
                    case 1:
                        button2.setImageResource(R.drawable.s3);
                        break;
                    case 2:
                        button3.setImageResource(R.drawable.s4);
                        break;
                    case 3:
                        button4.setImageResource(R.drawable.s1);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
        mFragment=new ArrayList<Fragment>();
        tab1=new Fragment1();
        tab2=new Fragment2();
        tab3=new Fragment3();
        tab4=new Fragment4();
        mFragment.add(tab1);
        mFragment.add(tab2);
        mFragment.add(tab3);
        mFragment.add(tab4);
        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }
        };
        mviewpage.setAdapter(mAdapter);

    }
}
