package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void clickLogin(View view) {
        Intent i = new Intent(this, Home.class);
        startActivity(i);
        finish();
    }

    public void clickSignUp(View view) {
        Intent i = new Intent(this, signUp.class);
        startActivity(i);
    }

    public void clickForgot(View view) {
        Intent i = new Intent(this, ForgotPassword_1.class);
        startActivity(i);
    }
}