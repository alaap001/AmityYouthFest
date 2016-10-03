package com.example.alaap.amityyouthfest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    Context c=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Thread thread = new Thread(){

            @Override
            public void run() {
try {
    super.run();
    sleep(3000);
}        catch (Exception e){
    e.printStackTrace();
}finally {
    startActivity(new Intent(c,MainActivity.class));
    finish();
}

            }
        };
thread.start();
    }
}
