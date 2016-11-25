package com.example.administrator.musicproject.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.administrator.musicproject.R;
import com.example.administrator.musicproject.adpter.SilideAdapter;
import com.example.administrator.musicproject.bean.SlideMene;
import java.util.ArrayList;
import java.util.List;
/*
* *
 * Created by Administrator on 2016/9/13.
 */
public class SildeFragment extends Fragment {
    public ListView listView;
    public List<SlideMene> list;
    public SilideAdapter adapter;
    public static SildeFragment newInstance() {
        Bundle args = new Bundle();
        SildeFragment fragment = new SildeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.slidefragment,container,false);
        initData();
        listView= (ListView) view.findViewById(R.id.list);
        adapter=new SilideAdapter(getContext(),list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SildeFragment.SetOnMenuClick cc=(SildeFragment.SetOnMenuClick)getActivity();
                cc.OnMenClick(""+list.get(position));
            }
        });
        return view;
    }
    private void initData() {
        list=new ArrayList<SlideMene>();
        int[] img_res_id = {
                R.mipmap.icon_search_dark,
                R.mipmap.icon_list_reapeat,
                R.mipmap.icon_change_background,
                R.mipmap.icon_sleep_mode,
                R.mipmap.icon_preferences_dark,
                R.mipmap.icon_exit
        };

        int[] menu_res_id = {
                R.string.scan,
                R.string.repeat_mode,
                R.string.change_bg,
                R.string.alarm,
                R.string.settings,
                R.string.exit,
        };
        for(int i=0;i<menu_res_id.length;i++) {
            SlideMene slideMene = new SlideMene();
            slideMene.setImage_Id(img_res_id[i]);
            slideMene.setText(menu_res_id[i]);
            list.add(slideMene);
        }
    }

    public interface  SetOnMenuClick{
        public void OnMenClick(String message);
    }
}
