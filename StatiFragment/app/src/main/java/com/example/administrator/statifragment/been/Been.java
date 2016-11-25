package com.example.administrator.statifragment.been;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public class Been  {

    public static List<Aticle>  PrepareData(){
        List<Aticle>  data=new ArrayList<>();
        for(int i=0;i<30;i++){
            Aticle a=new Aticle();
            a.setTitle("item"+i);
            a.setContent("今天是个美好的日子太阳很好，阳光很明媚"+i);
            data.add(a);
        }
        return  data;

    }
}
