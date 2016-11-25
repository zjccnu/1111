package com.example.administrator.musicproject.adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.musicproject.R;
import com.example.administrator.musicproject.bean.MusicInfo;
import com.example.administrator.musicproject.fragment.FavoriteFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public class FavoriteAdapter extends BaseAdapter {

    public List<MusicInfo> list;
    public  List<MusicInfo> favorite;
    public Context context;
    public FavoriteFragment.MusicFragmentToActivity c;
    public FavoriteAdapter(FavoriteFragment.MusicFragmentToActivity c,Context context,List<MusicInfo> list,List favorite) {
        this.list = list;
        this.context=context;
        this.c=c;
        this.favorite=favorite;
    }

    @Override
    public int getCount() {
        return favorite.size();
    }

    @Override
    public Object getItem(int position) {
        return favorite.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            View view= LayoutInflater.from(context).inflate(R.layout.musiclist_item,null);
            convertView=view;
            viewHolder.image= (ImageView) view.findViewById(R.id.favorite_iv);
            viewHolder.tv1= (TextView) view.findViewById(R.id.musicname_tv);
            viewHolder.tv2= (TextView) view.findViewById(R.id.artist_tv);
            viewHolder.tv3= (TextView) view.findViewById(R.id.duration_tv);
            viewHolder.linear= (LinearLayout) view.findViewById(R.id.linear);
            convertView.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.tv1.setText(favorite.get(position).musicName);
        viewHolder.tv2.setText(favorite.get(position).artist);
        viewHolder.tv3.setText(fromMilliToSecond(favorite.get(position).duration));
        Log.d("xxx","erwe"+favorite.size());
      //  final ViewHolder vh=viewHolder;
      /*  viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).favorite==0){
                    vh.image.setImageResource(R.drawable.icon_favourite_checked);
                    list.get(position).favorite=1;
                    favorite.add(list.get(position));
                }else {
                    vh.image.setImageResource(R.drawable.icon_favourite_normal);
                    list.get(position).favorite=0;
                    favorite.remove(list.get(position));
                }
            }
        });*/
        viewHolder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.playmusict(position);
            }
        });

        return convertView;
    }
    public String fromMilliToSecond(int duration) {
        // 60000 ==> 60s
        // 1分钟 -》 60毫秒
        int minute = duration/60000;
        int sec = (duration - minute*60000)/1000;
        return (minute<10?"0":"")+minute+":"+(sec<10?"0":"")+sec;
    }
    class ViewHolder{
        LinearLayout linear;
        ImageView image;
        TextView tv1,tv2,tv3;
    }
}
