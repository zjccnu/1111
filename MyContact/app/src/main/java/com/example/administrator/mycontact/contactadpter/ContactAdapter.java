package com.example.administrator.mycontact.contactadpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.example.administrator.mycontact.R;
import com.example.administrator.mycontact.us.Contact;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19.
 */
public class ContactAdapter extends BaseAdapter {
    List<Contact> list;
    LayoutInflater inflater;
    public ContactAdapter(Context context,List<Contact> list){
        this.inflater=LayoutInflater.from(context);
        this.list=list;
        for(Contact contact:list){
            Log.d("姓名:","我是adpter:"+contact.getName());
        }
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
        Contact contact;
        ViewHolder viewHolder;
        contact= (Contact) getItem(position);
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.contact_item,null);
            viewHolder.name= (EditText) convertView.findViewById(R.id.name);
            viewHolder.qq= (EditText) convertView.findViewById(R.id.qq);
            viewHolder.phone= (EditText) convertView.findViewById(R.id.phone);
            convertView.setTag(viewHolder);
        }else {

            viewHolder= (ViewHolder) convertView.getTag();
            viewHolder.name.setText(contact.getName());
            viewHolder.qq.setText(contact.getQq());
            viewHolder.phone.setText(contact.getPhone());
        }
        return convertView;
    }
    class  ViewHolder{
        EditText name;
        EditText qq;
        EditText phone;
    }
}
