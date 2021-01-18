package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Welcome_1 extends AppCompatActivity {

    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_1);

        fAuth = FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser() != null ){
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        }

    }

    public void clickGetStarted(View view) {
        Intent i = new Intent(Welcome_1.this, Welcome_2.class);
        startActivity(i);
        finish();
    }
}