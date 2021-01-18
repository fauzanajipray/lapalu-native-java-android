package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(fAuth.getCurrentUser() != null ){
                    startActivity(new Intent(getApplicationContext(), Home.class));
                    finish();
                } else {
                    Intent i = new Intent(MainActivity.this, Welcome_1.class);
                    startActivity(i);
                    finish();
                }
            }
        },5000);
    }


}