package com.example.administrator.statifragment.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.statifragment.R;
import com.example.administrator.statifragment.been.Aticle;
import com.example.administrator.statifragment.been.Been;

import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public class ListAdpter extends BaseAdapter {

    List<Aticle> data;
    Context context;

    public ListAdpter(Context context) {
        this.context=context;
        this.data = Been.PrepareData();
    }

    @Override
    public int getCount() {
        return data.size();
    }


    @Override
    public Object getItem(int position) {
        return data.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView tv;
        Aticle aticle=data.get(position);
        if(convertView==null){
            ViewHolder viewHolder=new ViewHolder();
            View view= LayoutInflater.from(context).inflate(R.layout.item,null);
            viewHolder.tv= (TextView) view.findViewById(R.id.tv);
            viewHolder.imge= (ImageView) view.findViewById(R.id.imge);
            //不要忘记这个
            convertView=view;
            imageView=viewHolder.imge;
            tv=viewHolder.tv;
            convertView.setTag(viewHolder);
        }else{
            ViewHolder viewHolder= (ViewHolder) convertView.getTag();
            imageView=viewHolder.imge;
            tv=viewHolder.tv;
        }
        imageView.setImageResource(R.mipmap.ic_launcher);
        tv.setText(aticle.getTitle());

        return convertView;
    }
    class  ViewHolder{
        TextView tv;
        ImageView imge;
    }
}
