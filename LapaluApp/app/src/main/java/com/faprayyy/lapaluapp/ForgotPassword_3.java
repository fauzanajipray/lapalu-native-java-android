package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForgotPassword_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_3);
    }

    public void clickToSet(View view) {
        Intent i = new Intent(this, ForgotPassword_4.class);
        startActivity(i);
        finish();
    }

    public void clickGetStarted(View view) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }
}