package com.example.administrator.musicproject.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.musicproject.R;
import com.example.administrator.musicproject.bean.SlideMene;

import java.util.List;
/**
 * Created by Administrator on 2016/9/13.
 */
public class SilideAdapter extends BaseAdapter {
    public Context context;
    public List<SlideMene> list;
    public SilideAdapter(Context context,List<SlideMene> list) {
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolider viewHolider;
        if(convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.slideitem,null);
            viewHolider=new ViewHolider();
            viewHolider.image= (ImageView) convertView.findViewById(R.id.image);
            viewHolider.text= (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(viewHolider);
        }
        viewHolider= (ViewHolider) convertView.getTag();
        viewHolider.image.setImageResource(list.get(position).getImage_Id());
        viewHolider.text.setText(list.get(position).getText());
        return convertView;
    }

    public class  ViewHolider{
        ImageView image;
        TextView text;
    }
}
