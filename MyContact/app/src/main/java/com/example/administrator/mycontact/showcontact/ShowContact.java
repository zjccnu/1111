package com.example.administrator.mycontact.showcontact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.administrator.mycontact.R;
import com.example.administrator.mycontact.bean.ContactDao;
import com.example.administrator.mycontact.contactadpter.ContactAdapter;
import com.example.administrator.mycontact.us.Contact;

import java.util.ArrayList;
import java.util.List;

public class ShowContact extends AppCompatActivity {
    ListView listView;
    List<Contact> list;

    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<Contact>();
        setContentView(R.layout.activity_show_contact);
        listView= (ListView) findViewById(R.id.list);
        ContactDao contactDao=new ContactDao(getApplicationContext());
        list=contactDao.searchContact(8);
      //  setdata();
        init();


    }

    private void setdata() {
        Contact contact=new Contact();
        contact.setName("zhoujian1");
        contact.setPhone("13659870359");
        contact.setQq("406524391");
        list.add(contact);


        Contact contact1=new Contact();
        contact1.setName("zhoujian2");
        contact1.setPhone("13659870359");
        contact1.setQq("406524391");
        list.add(contact1);


        Contact contact2=new Contact();
        contact2.setName("zhoujian3");
        contact2.setPhone("13659870359");
        contact2.setQq("406524391");
        list.add(contact2);


        Contact contact3=new Contact();
        contact3.setName("zhoujian4");
        contact3.setPhone("13659870359");
        contact3.setQq("406524391");
        list.add(contact3);


        Contact contact4=new Contact();
        contact4.setName("zhoujian5");
        contact4.setPhone("13659870359");
        contact4.setQq("406524391");
        list.add(contact4);
    }

    private void init() {
       contactAdapter=new ContactAdapter(getBaseContext(),list);
        listView.setAdapter(contactAdapter);
    }

}
