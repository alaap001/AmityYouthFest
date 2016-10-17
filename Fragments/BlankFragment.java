package com.example.alaap.amityyouthfest.Fragments;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alaap.amityyouthfest.R;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends android.app.Fragment {


    LinearLayout linearLayout;
    TextView marqueetext, months, days, hours,daytext,monthstext,hourtext;

    public BlankFragment() {
        // Required empty public constructor
    }

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        marqueetext = (TextView) rootView.findViewById(R.id.marquee);
        marqueetext.setSelected(true);
        months = (TextView) rootView.findViewById(R.id.months);
        days = (TextView) rootView.findViewById(R.id.days);
        hours = (TextView) rootView.findViewById(R.id.hours);
        linearLayout = (LinearLayout) rootView.findViewById(R.id.linearlayoutid);
daytext = (TextView)rootView.findViewById(R.id.daystext);
        monthstext = (TextView)rootView.findViewById(R.id.monthtext);
        hourtext = (TextView)rootView.findViewById(R.id.hourstext);

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String futuredate = "02/14/2017 00:00:00";

        Date d1 = new Date();
        Date d2 = null;
        try {
            String current = format.format(d1);
            d1 = format.parse(current);

            d2 = format.parse(futuredate);

            long diff = d2.getTime() - d1.getTime();

            int diffdays = (int) (diff / (24 * 60 * 60 * 1000));
            int diffmonths = (int)Math.round((diffdays / 30.417)-1);
            int diffdays2 = (int) (diff / (24 * 60 * 60 * 1000)%30.417);
            int diffhours= (int) (diff / (1000 * 60 * 60) % 24);
            days.setText(Integer.toString(diffdays2));
            hours.setText(Integer.toString(diffhours));
            months.setText(Integer.toString(diffmonths));
            if(days.getText().equals("1")){
                monthstext.setText("Month");
            }
            if( hours.getText().equals("1")){
                daytext.setText("Day");
            }

            if( months.getText().equals("1")){
                hourtext.setText("Hour");
            }

        } catch (Exception e) {

        }

        return rootView;
    }

}
