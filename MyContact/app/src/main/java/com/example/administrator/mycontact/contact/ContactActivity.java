package com.example.administrator.mycontact.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.mycontact.MainActivity;
import com.example.administrator.mycontact.R;
import com.example.administrator.mycontact.bean.ContactDao;
import com.example.administrator.mycontact.us.Contact;

public class ContactActivity extends AppCompatActivity {

    EditText name;
    EditText qq_number;
    EditText phone_number;
    Button button;
    String nm;
    String qq;
    String phone;
    Contact contact;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact=new Contact();
                nm=name.getText().toString();
                qq=qq_number.getText().toString();
                phone=phone_number.getText().toString();
                contact.setName(nm);
                contact.setPhone(phone);
                contact.setQq(qq);
           //     Toast.makeText(ContactActivity.this,contact.getName()+"name",Toast.LENGTH_LONG).show();
                ContactDao contactDao=new ContactDao(getApplicationContext());
               Intent intent=new Intent(ContactActivity.this, MainActivity.class);
                startActivity(intent);
                
               Log.d("id为", String.valueOf(contactDao.AddContact(contact)));
  }
        });
    }

   public void init() {
       name= (EditText) findViewById(R.id.name);
       qq_number= (EditText) findViewById(R.id.qq_number);
       phone_number= (EditText) findViewById(R.id.phone_number);
       button= (Button) findViewById(R.id.button);
 }

}
