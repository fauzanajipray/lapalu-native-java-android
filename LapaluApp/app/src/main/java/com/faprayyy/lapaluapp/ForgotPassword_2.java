package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword_2 extends AppCompatActivity {

    EditText edCode;
    String codeEmpty, codeMaxLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_2);
    }

    public void clickToNext(View view) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }

    public void toForgot(View view) {
        startActivity(new Intent(getApplicationContext(), ForgotPassword_1.class));
        finish();
    }
}