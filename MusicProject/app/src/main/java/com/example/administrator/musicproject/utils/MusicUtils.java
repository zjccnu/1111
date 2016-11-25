package com.example.administrator.musicproject.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.administrator.musicproject.bean.MusicInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by abiguime on 2016/9/7.
 */

public class MusicUtils {
    private static final String TAG = "MusicUtils";
  /*   public static final String KEY_ID = "_id";
	public static final String KEY_ALBUM_ID = "album_id";
	public static final String KEY_DURATION = "duration";
	public static final String KEY_TITLE = "title";
	public static final String KEY_ARTIST = "artist";

	public static final String KEY_DATA = "_data";

	public static final String KEY_FAVORITE = "favorite";*/
    private static final String[] PROJECTION = {
            MusicInfo.KEY_ID,
            MusicInfo.KEY_ALBUM_ID,
            MusicInfo.KEY_DURATION,
            MusicInfo.KEY_ARTIST,
            MusicInfo.KEY_DATA,
            MusicInfo.KEY_MUSIC_TITLE,
            MusicInfo.KEY_ARTIST_ID,
    };
    /* 扫描本地音乐 更新数据库 */
    public static List<MusicInfo> querySystemMusic(Context ctx) {

        ContentResolver cr = ctx.getContentResolver();
        Uri gmusic = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor query = cr.query(gmusic, PROJECTION, null, null, null);
        return parseMusic(query); /* 获取音乐列表 */
        // 想应用的本地数据库保存获取好的音乐。。。
        /*音乐保存到本地数据库里*/
        /*SqliteOpenHelper*/
    }

    public static List<MusicInfo> parseMusic(Cursor query) {

        List<MusicInfo> msinfo = new ArrayList<>();

      while (query.moveToNext()) {
            MusicInfo tmp = new MusicInfo();
            tmp._id = query.getInt(query.getColumnIndex(MusicInfo.KEY_ID)); /* 音乐id */
            tmp.albumId = query.getInt(query.getColumnIndex(MusicInfo.KEY_ALBUM_ID)); /*音乐专辑id*/
            tmp.duration = query.getInt(query.getColumnIndex(MusicInfo.KEY_DURATION));  /*音乐时间长度*/
            tmp.artist = query.getString(query.getColumnIndex(MusicInfo.KEY_ARTIST));  /*作者名字*/
            tmp.artist_id = query.getString(query.getColumnIndex(MusicInfo.KEY_ARTIST_ID));  /*作者id*/
            tmp.musicName = query.getString(query.getColumnIndex(MusicInfo.KEY_MUSIC_TITLE));  /*音乐名称*/
            tmp.data = query.getString(query.getColumnIndex(MusicInfo.KEY_DATA));  /*音乐绝对目录*/
            tmp.folder = tmp.data.substring(0, tmp.data.lastIndexOf("/")+1);  /*音乐所在文件夹*/
            msinfo.add(tmp);
        }
    return msinfo;
    }
}
