package com.tz.abiguime.basicsclass.project.fragments;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.tz.abiguime.basicsclass.project.R;
import com.tz.abiguime.basicsclass.project.bean.MusicInfo;
import com.tz.abiguime.basicsclass.project.fragments.intrf.ActivityToMusicListFrgInterface;
import com.tz.abiguime.basicsclass.project.fragments.intrf.MusicFragmentInteface;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by abiguime on 2016/9/10.
 */

public class MusicListFragment extends Fragment implements ActivityToMusicListFrgInterface {

    private static final String ID = "ID";

    public static MusicListFragment newInstance(List<MusicInfo> data) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(ID, (ArrayList<? extends Parcelable>) data);
        MusicListFragment fragment = new MusicListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    ListView lv;
    List<MusicInfo> data;
    MusicListAdapter adap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.music_list_fragment, container, false);

        lv = (ListView) rootview.findViewById(R.id.listview);
        /* 获取默认音乐列表 。*/
        data = getArguments().getParcelableArrayList(ID);
        adap = new MusicListAdapter(getContext(), data);
        lv.setAdapter(adap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MusicFragmentInteface)getActivity()).play(position, adap.data);
            }
        });
        return rootview;
    }


    @Override
    public void updateData(List<MusicInfo> data) {
        /*同过新的数据-》更新列表*/
        if (adap == null) {
            adap = new MusicListAdapter(getContext(), data);
            lv.setAdapter(adap);
        } else {
            adap.updateData(data);
        }
    }


    public class MusicListAdapter extends BaseAdapter {

        private List<MusicInfo> data;
        private final Context ctx;

        public MusicListAdapter(Context ctx, List<MusicInfo> data) {
            this.ctx = ctx;
            this.data = data;
        }

        public void updateData(List<MusicInfo> d) {
            this.data = d;
            notifyDataSetChanged(); // 通知listview（你需要重绘视图）
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

            MusicInfo item = (MusicInfo) getItem(position);
            ViewHolder vh = null;
            if (convertView == null) {
                convertView = (LayoutInflater.from(ctx))
                        .inflate(R.layout.musiclist_item, parent, false);
                vh = new ViewHolder(convertView);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }
            Log.d("xxx", item.toString());
            // 数据
            vh.tv_music_name.setText(item.musicName);
            vh.tv_music_artist.setText(item.artist);
            vh.tv_music_duration.setText(this.fromMilliToSecond(item.duration));

            vh.iv_play_state.setVisibility(View.GONE); //
            if (item.getFavorite() == 1)
                vh.iv_favorite.setImageResource(R.mipmap.icon_favorite_on); //
            else
                vh.iv_favorite.setImageResource(R.mipmap.icon_favourite_normal); //

            convertView.setTag(vh);
            return convertView;
        }

        private String fromMilliToSecond(int duration) {

            // 60000 ==> 60s
            // 1分钟 -》 60毫秒
            int minute = duration/60000;
            int sec = (duration - minute*60000)/1000;
            return (minute<10?"0":"")+minute+":"+(sec<10?"0":"")+sec;
        }


        public class ViewHolder {

            public ImageView iv_favorite; // 是否收藏图
            public ImageView iv_play_state; // 播放状态图 （暂停，在播放）
            public TextView tv_music_name; // 音乐名称
            public TextView tv_music_duration; // 音乐长度
            public TextView tv_music_artist; // 音乐歌手

            public ViewHolder (View view) {
                this.iv_favorite = (ImageView) view.findViewById(R.id.favorite_iv);
                this.iv_play_state = (ImageView) view.findViewById(R.id.playstate_iv);
                this.tv_music_artist = (TextView) view.findViewById(R.id.artist_tv);
                this.tv_music_duration = (TextView) view.findViewById(R.id.duration_tv);
                this.tv_music_name = (TextView) view.findViewById(R.id.musicname_tv);

            }

        }

    }
}
