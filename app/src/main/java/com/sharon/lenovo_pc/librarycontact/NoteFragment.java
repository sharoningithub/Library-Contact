package com.sharon.lenovo_pc.librarycontact;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo-pc on 2016/11/10.
 */
public class NoteFragment extends Fragment{
    private ListView notelist;
    private SimpleAdapter adapter;
    private List<Map<String,String>>datalist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab01,container,false);
        notelist= (ListView) view.findViewById(R.id.NoteList);
        datalist=new ArrayList<Map<String, String>>();
        adapter=new SimpleAdapter(getActivity(),getdata(),R.layout.note_adapter,new String[]{"title","time"},new int[]{R.id.note_title,R.id.note_time});
        notelist.setAdapter(adapter);
        return view;
    }

    private List<Map<String,String>> getdata(){
        for (int i=0;i<20;i++)
        {
            Map<String,String>map=new HashMap<String, String>();
            map.put("title","tile"+i);
            map.put("time","time"+i);
            datalist.add(map);
        }
        return datalist;
    }

}
