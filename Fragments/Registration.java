package com.example.alaap.amityyouthfest.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alaap.amityyouthfest.AmityRegistration;
import com.example.alaap.amityyouthfest.ForeignRegistration;
import com.example.alaap.amityyouthfest.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registration extends android.app.Fragment {


    Button amity, foreign;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.registration, container, false);
        amity = (Button) rootView.findViewById(R.id.amity);
        foreign = (Button) rootView.findViewById(R.id.foreign);

        amity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AmityRegistration.class));
            }
        });
        foreign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ForeignRegistration.class));
            }
        });

        return rootView;
    }

}
