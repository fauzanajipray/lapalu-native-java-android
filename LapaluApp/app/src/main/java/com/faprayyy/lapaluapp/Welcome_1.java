package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Welcome_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_1);

    }

    public void clickGetStarted(View view) {
        Intent i = new Intent(Welcome_1.this, Welcome_2.class);
        startActivity(i);
        finish();
    }
}