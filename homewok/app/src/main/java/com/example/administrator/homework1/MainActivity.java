package com.example.administrator.homework1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.homework1.pro.attention.view.AttentionFragment;
import com.example.administrator.homework1.pro.essence.view.EssenceFragment;
import com.example.administrator.homework1.pro.mine.view.MineFragment;
import com.example.administrator.homework1.pro.newpost.view.NewpostFragment;
import com.example.administrator.homework1.pro.publish.view.PublishFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<TabItem>  tabItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabData();
        initTabHost();
    }
    private void initTabData(){
         tabItemList=new ArrayList<>();
        tabItemList.add(new TabItem(R.drawable.main_bottom_essence_normal,R.drawable.main_bottom_mine_press,R.string.main_essence_text, EssenceFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_newpost_normal,R.drawable.main_bottom_newpost_press,R.string.main_newpost_text, NewpostFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_public_normal,R.drawable.main_bottom_public_press,0, PublishFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_attention_normal, R.drawable.main_bottom_attention_press, R.string.main_attention_text, AttentionFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_mine_normal, R.drawable.main_bottom_mine_press, R.string.main_mine_text, MineFragment.class));

    }
    private void initTabHost(){
        FragmentTabHost fragmentTabHost=(FragmentTabHost)findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        for(int i=0;i<tabItemList.size();i++){
            TabItem tabItem=tabItemList.get(i);
            //绑定Fragment

        }

    }
    //代表每一个tab
    class TabItem{
        //正常情况下显示的图片
        private  int imageNormal;
        //选中情况下显示的图片
        private int imagePress;
        private  int title;
        private String titleString;
        private Class<? extends Fragment> fragmentclass;
        public TabItem(int imageNormal,int imagePress,int title,Class<? extends Fragment> fragmentclass){
            this.imageNormal=imageNormal;
            this.imagePress=imagePress;
            this.title=title;
        }
        public  int getImageNormal(){
            return imageNormal;
        }
        public  int getImagePress(){
            return  imagePress;
        }
        public  int getTitle(){
            return  title;
        }

    }
}
