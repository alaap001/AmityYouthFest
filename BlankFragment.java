package com.example.alaap.amityyouthfest;


import android.annotation.TargetApi;
import android.graphics.drawable.AnimationDrawable;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends android.app.Fragment {

    LinearLayout linearLayout;
TextView marqueetext,days,hours,minutes;
    public BlankFragment() {
        // Required empty public constructor
    }

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_blank, container, false);
        marqueetext= (TextView) rootView.findViewById(R.id.marquee);
        marqueetext.setSelected(true);
        days= (TextView) rootView.findViewById(R.id.days);
        hours= (TextView) rootView.findViewById(R.id.hours);
        minutes= (TextView) rootView.findViewById(R.id.minutes);
        linearLayout=(LinearLayout)rootView.findViewById(R.id.linearlayoutid);

/*        AnimationDrawable animationDrawable=new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ayfthree),5000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ayf),5000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ayg_two),5000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ayg_two),5000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.sangathan),5000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.freshers_group_two),5000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.freshers_grp),5000);
        animationDrawable.setOneShot(false);
        animationDrawable.setAlpha(80);
        animationDrawable.start();
        linearLayout.setBackground(animationDrawable);

        */
        return rootView;
    }

}
