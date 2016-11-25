package com.example.administrator.mmmd.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mmmd.R;
import com.example.administrator.mmmd.navigation.NewpostNavigation;
import com.example.administrator.mmmd.utils.ToastUtil;

/**
 * Created by Administrator on 2016/6/7.
 */
public class NewpostFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_newpost,container,false);
        Inittoobar(container);
        return view;
    }

    private void Inittoobar(View viewContent) {
        NewpostNavigation builder=new NewpostNavigation(getContext());
        builder.setTitleIcon(R.drawable.main_essence_title)
                .setLeftIcon(R.drawable.main_essence_btn_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(), "点击了");
                    }
                }).setLeftIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast(getContext(),"点击了");
            }
        });
        builder.createAndBind((ViewGroup)viewContent);
    }
}

