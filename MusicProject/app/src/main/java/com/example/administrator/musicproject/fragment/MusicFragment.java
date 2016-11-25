package com.example.administrator.musicproject.fragment;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.musicproject.R;
import com.example.administrator.musicproject.adpter.MusicListAdapter;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {
     public List list;
    public List favorite;
    public ListView listview;
    public ImageView image;
    public static MusicFragment newInstance(List list,List favorite) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("MUSICINFO",(ArrayList<? extends Parcelable>) list);
        args.putParcelableArrayList("favorite", (ArrayList<? extends Parcelable>) favorite);
        MusicFragment fragment = new MusicFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_music, container, false);
        list=new ArrayList<>();
        list=getArguments().getParcelableArrayList("MUSICINFO");
        favorite=getArguments().getParcelableArrayList("favorite");
        MusicFragment.MusicFragmentToActivity c= (MusicFragmentToActivity) getActivity();
        MusicListAdapter adapter=new MusicListAdapter(c,getContext(),list,favorite);
        listview= (ListView) view.findViewById(R.id.music_list);
        listview.setAdapter(adapter);

     /*   listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  MusicFragment.MusicFragmentToActivity c= (MusicFragmentToActivity) getActivity();
                c.playmusic(position);

            }
        });*/
        return view;
    }
  public interface  MusicFragmentToActivity{
      public void playmusic(int position);
  }


}
