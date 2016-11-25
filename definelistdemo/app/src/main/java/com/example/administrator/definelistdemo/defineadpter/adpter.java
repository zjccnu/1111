package com.example.administrator.definelistdemo.defineadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.definelistdemo.R;
import com.example.administrator.definelistdemo.been.fruitbeen;

import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
public class adpter extends BaseAdapter{
    List<fruitbeen> list;
    private LayoutInflater inflater;
    public adpter(Context context, List <fruitbeen> list){
        this.list=list;
        this.inflater=LayoutInflater.from(context);
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
        ViewHolder viewHolder;
        fruitbeen fruit= (fruitbeen) getItem(position);
        if(convertView==null){
          convertView=inflater.inflate(R.layout.item_layout,null);
           viewHolder=new ViewHolder();
           viewHolder.imageView= (ImageView) convertView.findViewById(R.id.image);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(viewHolder);
        }else{
        viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.imageView.setImageResource(fruit.getFruitId());
        viewHolder.textView.setText(fruit.getName());
        }
      return  convertView;
    }
    class  ViewHolder{
       ImageView imageView;
        TextView textView;
    }
}
