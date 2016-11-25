package com.example.administrator.myapplication;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
public class MainActivity extends AppCompatActivity {
    private static final String TAG1 ="imagesoure" ;
    private static final String TAG2 ="sdfasdf" ;
    FrameLayout frame;
    Fragment frag;
    Fragment frag2;
    Button bt;
    FragmentTransaction tran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        frame= (FrameLayout) findViewById(R.id.fram);
        bt= (Button) findViewById(R.id.but);
        tran = getSupportFragmentManager().beginTransaction();
        if(frag==null){
            frag=Image_fragment.newInstance(R.drawable.girl);
            if(getSupportFragmentManager().findFragmentByTag(TAG1)==null)
            {
                tran.add(R.id.fram,frag,TAG1);
            }

            tran.commit();
        }
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tran = getSupportFragmentManager().beginTransaction();
                if (frag2 == null) {
                    frag2 = Image_fragment.newInstance(R.drawable.man);
                    for (int i = 0; i < getSupportFragmentManager().getFragments().size(); i++) {
                        if (getSupportFragmentManager().getFragments().get(i) != null)
                            tran.hide(getSupportFragmentManager().getFragments().get(i));
                    }
                    if (getSupportFragmentManager().findFragmentByTag(TAG2) == null) {
                        tran.add(R.id.fram, frag2, TAG2);
                    }
                    tran.addToBackStack(null);//将fragment放入栈中，按返回键就不会直接退出
                    tran.commit();
                }
            }
        });
    }
    
    @Override
    public void onBackPressed() {
        if (!getSupportFragmentManager().popBackStackImmediate())
            super.onBackPressed();
    }
}
