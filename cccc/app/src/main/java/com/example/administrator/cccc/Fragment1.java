package com.example.administrator.cccc;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment1 extends  Fragment implements AdapterView.OnItemClickListener{

    ListView listview;
    ArrayAdapter adapter=null;
    ArrayList<String> arrayList;
    private  String[]  list={"1","2","3","4"};

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab1, container,false);
        listview=(ListView)view.findViewById(R.id.list1);
        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
        listview.setAdapter(adapter);
        return view;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
