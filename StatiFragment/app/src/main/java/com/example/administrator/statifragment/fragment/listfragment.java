package com.example.administrator.statifragment.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.statifragment.R;
import com.example.administrator.statifragment.adpter.ListAdpter;
import com.example.administrator.statifragment.been.Aticle;
import com.example.administrator.statifragment.been.Been;

/**
 * A simple {@link Fragment} subclass.
 */
public class listfragment extends Fragment{
    public listfragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_listfragment, container, false);
        ListView ls= (ListView) view.findViewById(R.id.listview);
        ListAdpter adpter=new ListAdpter(getContext());
        ls.setAdapter(adpter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aticle aticle=Been.PrepareData().get(position);
               // Toast.makeText(getActivity(),aticle.getContent()+"我是第"+position+"个item",Toast.LENGTH_LONG).show();
                //上转型对象
                listfragment.PostdataToActivity c= (PostdataToActivity) getActivity();
                Log.d("xx",aticle.getContent());
               c.PostToActivty(aticle);
            }
        });
        return view;
    }

public interface PostdataToActivity{
    public void PostToActivty(Aticle aticle);
}

}
