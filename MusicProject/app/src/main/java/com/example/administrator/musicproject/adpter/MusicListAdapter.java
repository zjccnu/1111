package com.example.administrator.musicproject.adpter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.musicproject.R;
import com.example.administrator.musicproject.bean.MusicInfo;
import com.example.administrator.musicproject.db.AppOpenHelper;
import com.example.administrator.musicproject.fragment.MusicFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class MusicListAdapter extends BaseAdapter {
   public List<MusicInfo> list;
    public  List<MusicInfo> favorite;
   public Context context;
    public MusicFragment.MusicFragmentToActivity c;
    public MusicListAdapter(MusicFragment.MusicFragmentToActivity c,Context context,List<MusicInfo> list,List favorite) {
        this.list = list;
        this.context=context;
        this.c=c;
        this.favorite=favorite;
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
        viewHolder.tv1.setText(list.get(position).musicName);
        viewHolder.tv2.setText(list.get(position).artist);
        viewHolder.tv3.setText(fromMilliToSecond(list.get(position).duration));
        final ViewHolder vh=viewHolder;
        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).favorite==0){
                    vh.image.setImageResource(R.drawable.icon_favourite_checked);
                    list.get(position).favorite=1;
                    favorite.add(list.get(position));
                    setFavorite(position, 1);
                }else {
                    vh.image.setImageResource(R.drawable.icon_favourite_normal);
                    list.get(position).favorite=0;
                    favorite.remove(list.get(position));
                  //  setFavorite(position, 0);
                }
            }
        });
        viewHolder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.playmusic(position);
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
    /*(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + " songid integer, albumid integer, duration integer, musicname varchar(10), "
            + "artist char, data char, folder char, musicnamekey char, artistkey char, favorite integer)");*/
    public   void  setFavorite(final int postion, final int favorite){
        new Thread(new Runnable() {
            @Override


            public void run() {
                SQLiteDatabase db=AppOpenHelper.getInstance(context);
                String sql="insert into "+AppOpenHelper.TABLE_MUSIC+"(_id,data,musicname,artist,duration,folder,songid)"
                        +"values ("+
                        list.get(postion)._id +","+"'"+
                        list.get(postion).data+"'"+","+"'"+
                        list.get(postion).musicName+"'"+","+"'"+
                        list.get(postion).artist+"'"+","+
                        list.get(postion).duration+","+"'"+
                        list.get(postion).folder+"'"+","+
                        list.get(postion).songId+
                        ")";
                db.execSQL(sql);

            }
        }).start();
    }
}
