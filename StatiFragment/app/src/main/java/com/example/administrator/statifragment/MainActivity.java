package com.example.administrator.statifragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.statifragment.been.Aticle;
import com.example.administrator.statifragment.fragment.listfragment;

public class MainActivity extends AppCompatActivity implements listfragment.PostdataToActivity{

    Fragment contentfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentfragment= getSupportFragmentManager().findFragmentById(R.id.contentfragment);

    }

    @Override
    public void PostToActivty(Aticle aticle) {
         //必须在里面调用否则会空指针异常
        MainActivity.PostDataToFragment c= (PostDataToFragment) contentfragment;
        c.PostToFragment(aticle);


    }

    private void mt(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public   interface PostDataToFragment{
        public  void PostToFragment(Aticle aticle);
    }

}

