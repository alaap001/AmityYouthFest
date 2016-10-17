package com.example.alaap.amityyouthfest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Dialog_activity extends Activity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_activity);
        Intent intent = getIntent();
        if (intent != null) {
            int imageid = intent.getIntExtra("CountryImage", R.drawable.default_contact);
            String imagename = intent.getStringExtra("countryname");
            ImageView myimage = (ImageView) findViewById(R.id.imagecoun);
            myimage.setImageResource(imageid);
            TextView textView = (TextView) findViewById(R.id.textcoun);
            textView.setText(imagename);
        }
    }
}
