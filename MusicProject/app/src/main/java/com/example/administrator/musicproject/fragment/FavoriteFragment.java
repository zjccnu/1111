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
import com.example.administrator.musicproject.adpter.FavoriteAdapter;
import com.example.administrator.musicproject.bean.MusicInfo;
import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {
    public List<MusicInfo> list;
    public List<MusicInfo> favorite;
    public ListView listview;
    public ImageView image;
    public static FavoriteFragment newInstance(List<MusicInfo> list,List<MusicInfo> favorite) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("MUSICINFO",(ArrayList<? extends Parcelable>) list);
        args.putParcelableArrayList("favorite", (ArrayList<? extends Parcelable>) favorite);
        FavoriteFragment fragment = new FavoriteFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_favorite, container, false);
        list=new ArrayList<>();
        list=getArguments().getParcelableArrayList("MUSICINFO");
        favorite=getArguments().getParcelableArrayList("favorite");
        FavoriteFragment.MusicFragmentToActivity c= (MusicFragmentToActivity) getActivity();
        FavoriteAdapter adapter=new FavoriteAdapter(c,getContext(),list,favorite);
        listview= (ListView) view.findViewById(R.id.favorite_list);
       listview.setAdapter(adapter);
        return view;
    }
    public interface  MusicFragmentToActivity{
        public void playmusict(int position);
    }

}
