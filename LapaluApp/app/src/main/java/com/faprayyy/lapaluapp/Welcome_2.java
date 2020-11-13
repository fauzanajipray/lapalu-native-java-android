package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Welcome_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_2);
    }

    public void clickGetStarted(View view) {
        Intent i = new Intent(Welcome_2.this, Welcome_3.class);
        startActivity(i);
        finish();
    }
}