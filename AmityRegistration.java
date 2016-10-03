package com.example.alaap.amityyouthfest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class AmityRegistration extends AppCompatActivity {

    EditText amizoneid,amizonepass,fullname,email;

    Spinner eventspin,deptspin;
    String events[]={"event 1","enemt 2","event 3","ebent 4","event 5","event 6"};
    String dept[]={"ASET","ASF","ASS","ALS","ASB"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amity_registration);
        amizoneid= (EditText) findViewById(R.id.amizoneid);
        amizonepass= (EditText) findViewById(R.id.password);
        fullname= (EditText) findViewById(R.id.fullname);
        email = (EditText) findViewById(R.id.email);
        eventspin=(Spinner)findViewById(R.id.eventspinner);
        deptspin=(Spinner)findViewById(R.id.deptspinner);
        final ArrayAdapter<String> eventadapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,events);
        final ArrayAdapter<String> deptadapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,dept);
        eventspin.setAdapter(eventadapter);
        deptspin.setAdapter(deptadapter);

        eventspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CharSequence selected_event = eventadapter.getItem(position);
                // Toast.makeText(getActivity(),selected_event,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        deptspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CharSequence selected_dept = deptadapter.getItem(position);
                // Toast.makeText(getActivity(),selected_dept,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
