package com.example.administrator.retrofitdemo;

import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ViewUtil {
    public static void initData(MainActivity mainActivity) {
        Class clazz=mainActivity.getClass();
        //获取所有属性
        Field[] f=clazz.getDeclaredFields();
        for(Field ff:f){
            //暴力破解封装
         ff.setAccessible(true);
            //获取属性的类型
            Class type=ff.getType();
            //判断属性是不是继承自view
            if(View.class.isAssignableFrom(type))
            {
                try{
                    //获取activity的findViewById方法
                    Method method=clazz.getMethod("findViewById",int.class);
                    //加载R.id类的字节码
                    Class idclazz=R.id.class;
                    //获取属性名获得对应的R.id类中的属性
                    Field field=idclazz.getField(ff.getName());
                    //获取该属性对应的值
                    Object it=field.get(R.id.class);
                    //执行findViewById方法
                    Object  id= method.invoke(mainActivity, it);
                    //将返回的值赋值activity中对应的该属性
                    ff.set(mainActivity, id);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }
}
