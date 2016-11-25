package com.example.administrator.mydatabase.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/15.
 */
public class Mysqlitedatebase extends SQLiteOpenHelper{

    private Context mcontent;
    public  static  final  String SQL="create table us("+"id int AUTO_INCREMENT,"
                                                        +"username varchar(50),"
                                                        +"pwd varchar(30))";
    public Mysqlitedatebase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontent=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL);
        Toast.makeText(mcontent,"创建数据库成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
