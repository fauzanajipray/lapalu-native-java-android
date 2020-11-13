package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForgotPassword_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_1);
    }

    public void clickToSend(View view) {
        Intent i = new Intent(this, ForgotPassword_2.class);
        startActivity(i);
        finish();
    }

}