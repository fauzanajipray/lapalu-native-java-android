package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    private TextView tvtitle, tvdeskripsi, tvcategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdeskripsi = (TextView) findViewById(R.id.txtdeskripsi);
        tvcategory = (TextView) findViewById(R.id.txtcategory);
        img = (ImageView) findViewById(R.id.novelthumbnail);

        //Receive data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Noveltitle");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");

        tvtitle.setText(Title);
        tvdeskripsi.setText(Description);
        img.setImageResource(image);
    }
}