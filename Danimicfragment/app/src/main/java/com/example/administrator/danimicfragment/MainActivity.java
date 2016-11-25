package com.example.administrator.danimicfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.danimicfragment.fragment.Fragment1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv1,tv2,tv3;
    public  static  final String TAG1="FRAG1";
    public  static  final String TAG2="FRAG2";
    public  static  final String TAG3="FRAG3";
    Fragment frag1=null,frag2=null,frag3=null;
    FragmentTransaction tran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       initView();
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
    }

    public void initView(){
     //   frag1=new Fragment1();

        frag1=Fragment1.newInstance(1);
        tran = getSupportFragmentManager().beginTransaction();
        tran.add(R.id.frame, frag1, "FRAG1");
        tran.commit();
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        tv3= (TextView) findViewById(R.id.tv3);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv1:
                tran=getSupportFragmentManager().beginTransaction();
                if (frag1 == null)
               //     frag1=new Fragment1();
                    frag1=Fragment1.newInstance(1);
                    if(getSupportFragmentManager().findFragmentByTag(TAG1)==null)
                    {
                    tran.add(R.id.frame, frag1, TAG1);
                    }
                    else {
                        for (Fragment f : getSupportFragmentManager().getFragments()) {
                            tran.hide(f);
                        }



                }
                mt(String.valueOf(frag1.getArguments().getInt("1")));
                tran.show(frag1);
                tran.commit();
                break;
             case R.id.tv2:
                 tran=getSupportFragmentManager().beginTransaction();
                if (frag2 == null)
                     frag2=Fragment1.newInstance(2);
                 //   frag2=new Fragment2();
                    if(getSupportFragmentManager().findFragmentByTag(TAG2)==null)
                    tran.add(R.id.frame, frag2, TAG2);
                    else {
                        for (Fragment f : getSupportFragmentManager().getFragments()) {
                            tran.hide(f);
                        }

                    }

                 tran.show(frag2);
                 tran.commit();
                break;
            default:
                tran=getSupportFragmentManager().beginTransaction();
                if (frag3 == null)
                 frag3=Fragment1.newInstance(3);
                    if(getSupportFragmentManager().findFragmentByTag(TAG3)==null)
                    tran.add(R.id.frame, frag3, TAG3);
                    else {
                        for (Fragment f : getSupportFragmentManager().getFragments()) {
                            tran.hide(f);
                        }

                    }

                tran.show(frag3);
                tran.commit();
                }

        }

    private void mt(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



}

