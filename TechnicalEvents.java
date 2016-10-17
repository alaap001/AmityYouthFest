package com.example.alaap.amityyouthfest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TechnicalEvents extends Fragment {

    Context c = getActivity();
    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_technical_events,container,false);

       /* adapter = new RecyclerAdapter(c,getdata());
          // adapter.setClicklistener(this);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(c,LinearLayoutManager.VERTICAL,true));
        recyclerView.setAdapter(adapter);
*/
        return rootView;
    }
    public List<Information> getdata(){

        List<Information> data = new ArrayList<>();
        String sub[]={"From: 18 Feb 2016 To: 19 Feb 2016 [ 9:00AM - 5:00PM]"
                ,"From: 18 Feb 2016 To: 19 Feb 2016 [ 9:00AM - 6:00PM]",
                "From: 18 Feb 2016 To: 19 Feb 2016 [ 9:00AM - 5:00PM]",
                "From: 18 Feb 2016 To: 19 Feb 2016 [ 9:00AM - 5:00PM]"};
        String heading[]= {"THESAURAM","BEST MANAGER","MOCK PARLAIMENT","FASHION SHOW"};
        int[] header={R.drawable.recycleimage,R.drawable.recycleimage,R.drawable.recycleimage,R.drawable.recycleimage};
        int[] icon = {R.drawable.ic_keyboard_arrow_right_black_24dp
                ,R.drawable.ic_keyboard_arrow_right_black_24dp,
                R.drawable.ic_keyboard_arrow_right_black_24dp,
                R.drawable.ic_keyboard_arrow_right_black_24dp};
        for(int i=0;i<sub.length && i<heading.length &&i<icon.length && i<header.length;i++){
            Information current=new Information();
            current.head=header[i];
            current.icon=icon[i];
            current.header=heading[i];
            current.sub=sub[i];
            data.add(current);
        }
        return data;
    }
}
