package com.example.alaap.amityyouthfest.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alaap.amityyouthfest.Eventdetails;
import com.example.alaap.amityyouthfest.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Events extends android.app.Fragment {


    public Events() {
        // Required empty public constructor
    }

Button eventbutton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_events, container, false);

        eventbutton= (Button) rootView.findViewById(R.id.eventbtn);
        eventbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Eventdetails.class));
            }
        });
        return rootView;
    }

}
