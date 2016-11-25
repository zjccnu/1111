package com.example.administrator.bbb;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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
    protected void onCreate(Bundle savedInstanceState) {
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
        resetImg();
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
        button1.setImageResource(R.drawable.s1);
        button2.setImageResource(R.drawable.s2);
        button3.setImageResource(R.drawable.s3);
        button4.setImageResource(R.drawable.s4);
    }
    private  void setSelect(int i){
        FragmentManager fm=getFragmentManager();//管理器
        FragmentTransaction tan=fm.beginTransaction();
        hideFragment(tan);
        switch (i){
            case 0:
                if(tab1==null)
                {
                    tab1=new Fragment1();
                    tan.add(R.id.frame,tab1);//将组件添加进去
                }else
                {
                  tan.show(tab1);
                }
                button1.setImageResource(R.drawable.s3);
                break;
            case 1:
                if(tab2==null)
                {
                    tab2=new Fragment2();
                    tan.add(R.id.frame, tab2);
                }else
                {
                    tan.show(tab2);
                }
                button2.setImageResource(R.drawable.s3);
                break;
            case 2:
                if(tab3==null)
                {
                    tab3=new Fragment3();
                    tan.add(R.id.frame, tab3);
                }else
                {
                    tan.show(tab3);
                }
                button3.setImageResource(R.drawable.s3);
                break;
            case 3:
                if(tab4==null)
                {
                    tab4=new Fragment4();
                    tan.add(R.id.frame, tab4);
                }else
                {
                    tan.show(tab4);
                }
                button4.setImageResource(R.drawable.s3);
                break;
        }
        tan.commit();
    }
    private void initView() {

        s1=(LinearLayout)findViewById(R.id.s1);
        s2=(LinearLayout)findViewById(R.id.s2);
        s3=(LinearLayout)findViewById(R.id.s3);
        s4=(LinearLayout)findViewById(R.id.s4);
        button1=(ImageButton)findViewById(R.id.button1);
        button2=(ImageButton)findViewById(R.id.button2);
        button3=(ImageButton)findViewById(R.id.button3);
        button4=(ImageButton)findViewById(R.id.button4);

    }
    private void hideFragment(FragmentTransaction tan) {
        if(tab1!=null)
            tan.hide(tab1);
        if(tab2!=null)
            tan.hide(tab2);
        if(tab3!=null)
            tan.hide(tab3);
        if(tab4!=null)
            tan.hide(tab4);
    }
}
