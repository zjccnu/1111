package com.example.administrator.mycontact.contactdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/*
*
* Created by Administrator on 2016/8/18.
*
*/
public class ContactDatabase extends SQLiteOpenHelper {

public Context mcontext;
 public static final  String SQL= "create table "+ ContactTableContract.ContactTableEntry.TBNAME+"(" +
          ContactTableContract.ContactTableEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
          ContactTableContract.ContactTableEntry.NAME_ENTRY+" varchar(100) not null," +
          ContactTableContract.ContactTableEntry.PHONE_ENTRY+" varchar(11) not null, " +
          ContactTableContract.ContactTableEntry.QQ_ENTRY+" varchar(10) not null" +
          ")";

    public ContactDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,name, factory, version);
        mcontext=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(SQL);
        Log.d("sql", SQL);
   //  Toast.makeText(mcontext, "创建数据库成功", Toast.LENGTH_LONG).show();
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ ContactTableContract.ContactTableEntry.TBNAME);
         onCreate(db);
    }
}
