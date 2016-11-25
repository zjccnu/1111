package com.example.administrator.jasonfragmenttab.Entity;

import com.example.administrator.jasonfragmenttab.R;
import com.example.administrator.jasonfragmenttab.fragment.BlankFragment;
import com.example.administrator.jasonfragmenttab.fragment.Fragment2;
import com.example.administrator.jasonfragmenttab.fragment.Fragment3;
import com.example.administrator.jasonfragmenttab.fragment.Fragment4;
import com.example.administrator.jasonfragmenttab.fragment.Fragment5;

/**
 * Created by Administrator on 2016/8/21.
 */
public class Entity {
    public  static  int vt[]={
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,

   };
    public static String titile[]={
            "目录",
            "目录",
            "目录",
            "目录",
            "目录",
    };
    public static Class<?> fragmentClass[]={
                BlankFragment.class,
                Fragment2.class,
                Fragment3.class,
                Fragment4.class,
                Fragment5.class,
    };



}
