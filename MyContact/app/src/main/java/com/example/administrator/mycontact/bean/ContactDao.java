package com.example.administrator.mycontact.bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.administrator.mycontact.contactdatabase.ContactDatabase;
import com.example.administrator.mycontact.contactdatabase.ContactTableContract;
import com.example.administrator.mycontact.us.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/18.
 */
public class ContactDao {
   public static   ContactDatabase contactDatabase;
    Context context;
    public ContactDao(Context context){
        contactDatabase=new ContactDatabase(context,"my",null,1);
        this.context=context;
    }
    public  long AddContact(Contact contact){
        SQLiteDatabase db=contactDatabase.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ContactTableContract.ContactTableEntry.NAME_ENTRY, contact.getName());
        contentValues.put(ContactTableContract.ContactTableEntry.QQ_ENTRY, contact.getQq());
        contentValues.put(ContactTableContract.ContactTableEntry.PHONE_ENTRY, contact.getPhone());
       // Toast.makeText(ContactActivity.this,"插入数据成功",Toast.LENGTH_LONG).show();
        Toast.makeText(context,"添加成功",Toast.LENGTH_LONG);
        return db.insert(ContactTableContract.ContactTableEntry.TBNAME,null,contentValues);
 }
    /*通过数量获取联系方式*/
    public List<Contact> searchContact (int count) {

        // 可读的数据库版本
        SQLiteDatabase db = contactDatabase.getReadableDatabase();

        /* phone = 188 */

        Cursor cursor = db.query(ContactTableContract.ContactTableEntry.TBNAME, /*表名*/
                new String[]{"*"}, /*获取的字段*/
                "1==1",  /* 过滤器 */
                new String[]{},
                "",
                "",
                " " + ContactTableContract.ContactTableEntry._ID+" asc" // asc 从小到大 desc从大到小
        );


        List<Contact> l = new ArrayList<>();
        int i = 0;
        while (cursor.moveToNext()) {

            if (i == count)
                break;
            int id = cursor.getInt(cursor.getColumnIndex(ContactTableContract.ContactTableEntry._ID));
            String name = cursor.getString(cursor.getColumnIndex(ContactTableContract.ContactTableEntry.NAME_ENTRY));
            String phone = cursor.getString(cursor.getColumnIndex(ContactTableContract.ContactTableEntry.PHONE_ENTRY));
            String qqnumber = cursor.getString(cursor.getColumnIndex(ContactTableContract.ContactTableEntry.QQ_ENTRY));
            Contact contact = new Contact();
            contact.setName(name);
            contact.setQq(qqnumber);
            contact.setPhone(phone);
            l.add(contact);
            i++;
        }
        return l;
    }
}
