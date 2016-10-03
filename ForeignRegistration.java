package com.example.alaap.amityyouthfest;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class ForeignRegistration extends AppCompatActivity {

    Button register,dp;
    ImageView profilepic;
    Context c=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreign_registration);
profilepic=(ImageView)findViewById(R.id.profilepic);
        dp= (Button) findViewById(R.id.imagebutton);
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile=new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                profile.setType("image/*");
                startActivityForResult(profile,1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            if (data == null) {
                Toast.makeText(this,"Error Uploading",Toast.LENGTH_SHORT).show();
                return;
            }
                 Uri uri=data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                Cursor cursor = getContentResolver().query(uri,
                        filePathColumn, null, null, null);
                if (cursor != null) {

                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    profilepic.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                }else{

                    Toast.makeText(c,"cursor null",Toast.LENGTH_SHORT).show();
                }



        }
    }
}
