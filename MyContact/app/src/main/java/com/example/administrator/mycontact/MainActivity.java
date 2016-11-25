package com.example.administrator.mycontact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.mycontact.bean.ContactDao;
import com.example.administrator.mycontact.contact.ContactActivity;
import com.example.administrator.mycontact.showcontact.ShowContact;
import com.example.administrator.mycontact.us.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
     Button button;
     Button bt;
     Button bt2;
     Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        bt= (Button) findViewById(R.id.bt);
        bt2= (Button) findViewById(R.id.bt2);
        intent = new Intent(this, ContactActivity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactDao contactDao=new ContactDao(getApplicationContext());
                List<Contact> list=new ArrayList<Contact>();
                list=contactDao.searchContact(2);
                for(Contact contact:list)
                    Toast.makeText(MainActivity.this, contact.getName(), Toast.LENGTH_LONG).show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ShowContact.class);
                startActivity(intent);
            }
        });
    }


}
