package com.example.administrator.urlimageview;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.administrator.urlimageview.imageadpter.ImageAdaper;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageAdaper adaper=new ImageAdaper(this);
        ListView listView= (ListView) findViewById(R.id.lv);
        listView.setAdapter(adaper);
    }

}
