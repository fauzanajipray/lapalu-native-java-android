package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Welcome_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_3);
    }
    public void clickGetStarted(View view) {
        Intent i = new Intent(Welcome_3.this, Login.class);
        startActivity(i);
        finish();
    }
}