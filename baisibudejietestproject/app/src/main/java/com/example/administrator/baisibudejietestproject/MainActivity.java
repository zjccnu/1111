package com.example.administrator.baisibudejietestproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.administrator.baisibudejietestproject.Fragment.AttentionFragment;
import com.example.administrator.baisibudejietestproject.Fragment.EssenceFragment;
import com.example.administrator.baisibudejietestproject.Fragment.MineFragment;
import com.example.administrator.baisibudejietestproject.Fragment.NewpostFragment;
import com.example.administrator.baisibudejietestproject.Fragment.PublishFragment;
import com.example.administrator.baisibudejietestproject.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {
    List<TabItem> tabItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabData();
        initTabHost();
    }

    private void initTabHost(){
        //获取FragmentTabHost
        FragmentTabHost fragmentTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        //绑定TabHost(绑定我们的body)
        fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        //去掉分割线
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        for (int i= 0; i<tabItemList.size() ;i++){
            TabItem tabItem = tabItemList.get(i);
            //绑定Fragment(将Fragment添加到FragmentTabHost组件上面)
            //newTabSpec:代表Tab名字
            //setIndicator:图片(今天我们采用布局文件--Tab到样式我们自己做)
            TabHost.TabSpec tabSpec = fragmentTabHost.
                    newTabSpec(tabItem.getTitleString())
                    .setIndicator(tabItem.getView());
            //添加Fragment
            //tabSpec:选项卡
            //tabItem.getFragmentClass():具体的Fragment
            //tabItem.getBundle():给我们的具体的Fragment传参数
            fragmentTabHost.addTab(tabSpec,tabItem.getFragmentClass(),tabItem.getBundle());
            //给我们的Tab按钮设置背景
            fragmentTabHost.getTabWidget()
                    .getChildAt(i)
                    .setBackgroundColor(getResources().getColor(R.color.main_bottom_bg));
            //监听点击Tab
           fragmentTabHost.setOnTabChangedListener(this);
            //默认选中第一个Tab
            if (i == 0){
                tabItem.setChecked(true);
            }
        }
    }
    //切换时进行选择字体
    public void onTabChanged(String tabId) {
        ToastUtil.showToast(this, tabId);
        //重置Tab样式
        for (int i = 0;i < tabItemList.size();i++){
            TabItem tabItem = tabItemList.get(i);
            if (tabId.equals(tabItem.getTitleString())){
                //选中设置为选中壮体啊
                tabItem.setChecked(true);
            }else {
                //没有选择Tab样式设置为正常
                tabItem.setChecked(false);
            }
        }
    }

    //初始化Tab数据
    private void initTabData(){
        tabItemList = new ArrayList<TabItem>();
        //添加精华Tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_essence_normal
                ,R.drawable.main_bottom_essence_press,R.string.main_essence_text, EssenceFragment.class));
        //添加新帖Tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_newpost_normal
                ,R.drawable.main_bottom_newpost_press,R.string.main_newpost_text, NewpostFragment.class));
        //添加发布Tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_public_normal
                ,R.drawable.main_bottom_public_press,0, PublishFragment.class));
        //添加关注Tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_attention_normal
                ,R.drawable.main_bottom_attention_press,R.string.main_attention_text, AttentionFragment.class));
        //添加我的Tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_mine_normal
                ,R.drawable.main_bottom_mine_press,R.string.main_mine_text, MineFragment.class));

    }

    class  TabItem{
        int ImageNormal;
        int ImagePress;
        int title;
        View view;
        Bundle bundle;
        private ImageView imageView;
        private TextView textView;
        Class<?extends Fragment>  fragmentClass;
        String titleString;
       TabItem(int ImageNormal,int ImagePress,int title, Class<?extends Fragment>  fragmentClass){
           this.ImageNormal=ImageNormal;
           this.ImagePress=ImagePress;
           this.title=title;
           this. fragmentClass= fragmentClass;
       }
        public int getImageNormal(){
            return ImageNormal;
        }
        public int getImagePress(){
            return  ImagePress;
        }
        public int getTitle(){
            return  title;
        }
        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }
        public String getTitleString() {
            if (title == 0){
                return "";
            }
            if (TextUtils.isEmpty(titleString)){
                titleString = getString(title);
            }
            return titleString;
        }
        public View getView(){
            if (this.view == null){
                this.view = getLayoutInflater().inflate(R.layout.view_tab_indicator,null);
                this.imageView = (ImageView)this.view.findViewById(R.id.iv_tab);
                this.textView = (TextView) this.view.findViewById(R.id.tv_tab);
                //判断资源是否存在,不再我就因此
                if (this.title == 0){
                    this.textView.setVisibility(View.GONE);
                }else {
                    this.textView.setVisibility(View.VISIBLE);
                    this.textView.setText(getTitleString());
                }
                //绑定图片默认资源
                this.imageView.setImageResource(ImageNormal);
            }
            return this.view;
        }
        public Bundle getBundle(){
            if (bundle == null){
                bundle = new Bundle();
            }
            bundle.putString("title", getTitleString());
            return bundle;
        }
        public void setChecked(boolean isChecked){
            if(imageView != null){
                if (isChecked){
                    imageView.setImageResource(ImagePress);
                }else {
                    imageView.setImageResource(ImageNormal);
                }
            }
            if (textView != null && title != 0){
                if (isChecked){
                    textView.setTextColor(getResources().getColor(R.color.main_bottom_text_select));
                }else {
                    textView.setTextColor(getResources().getColor(R.color.main_bottom_text_normal));
                }
            }
        }


        }
    }



