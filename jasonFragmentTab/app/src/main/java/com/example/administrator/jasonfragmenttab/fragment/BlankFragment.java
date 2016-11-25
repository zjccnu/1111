package com.example.administrator.jasonfragmenttab.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jasonfragmenttab.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {
    ArrayList<Fragment> fragments;
    ViewPager pager;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BlankFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void InitView() {

        tv1= (TextView) view.findViewById(R.id.tv1);
        tv2= (TextView) view.findViewById(R.id.tv2);
        tv3= (TextView) view.findViewById(R.id.tv3);
        tv4= (TextView) view.findViewById(R.id.tv4);
        tv5= (TextView) view.findViewById(R.id.tv5);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        pager= (ViewPager) view.findViewById(R.id.psge);
        fragments=new ArrayList<>();
        Fragment one=new Fragment2();
        Fragment two=new Fragment3();
        Fragment three=new Fragment4();
        Fragment four=new Fragment5();
        Fragment five=new Fragment2();
        fragments.add(one);
        fragments.add(two);
        fragments.add(three);
        fragments.add(four);
        fragments.add(five);
        pager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                 Log.d("xxx", "你选择了第" + state + "个Fragment");
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     view= inflater.inflate(R.layout.fragment_blank, container, false);
        InitView();
        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.tv1:pager.setCurrentItem(0);
                Log.d("xxx", "你选择了第" + 1 + "个按钮");
                break;
            case R.id.tv2:pager.setCurrentItem(1);
                Log.d("xxx", "你选择了第" + 2 + "个按钮");
                break;
            case R.id.tv3:pager.setCurrentItem(2);
                Log.d("xxx", "你选择了第" + 3 + "个按钮");
                break;
            case R.id.tv4:pager.setCurrentItem(3);
                Log.d("xxx", "你选择了第" + 4 + "个按钮");
                break;
            case R.id.tv5:pager.setCurrentItem(4);
                Log.d("xxx", "你选择了第" + 5 + "个按钮");
                break;

        }
    }
}
