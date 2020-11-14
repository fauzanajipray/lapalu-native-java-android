package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword_3 extends AppCompatActivity {

    EditText edPassword, edVerifPassword;
    String passwordEmpty, formEmpty,  passwordVerifEmpty, passwordNotMatch, passwordMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_3);

        edPassword = findViewById(R.id.edPassword);
        edVerifPassword = findViewById(R.id.edVerifPassword);
        formEmpty = getResources().getString(R.string.form_empty);
        passwordEmpty = getResources().getString(R.string.password_empty);
        passwordVerifEmpty = getResources().getString(R.string.password_verif_empty);
        passwordNotMatch = getResources().getString(R.string.password_not_match);
        passwordMax = getResources().getString(R.string.password_max);
    }

    public void clickToSet(View view) {
        String newPass = edPassword.getText().toString().trim();
        String confirmPass = edVerifPassword.getText().toString().trim();

        if(TextUtils.isEmpty(edVerifPassword.getText().toString().trim())
                && TextUtils.isEmpty(edPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), formEmpty, Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(edVerifPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), passwordVerifEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(edPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), passwordEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (newPass.length() <= 8){
            Toast.makeText(view.getContext(), passwordMax, Toast.LENGTH_SHORT).show();
        }
        else if (!newPass.equals(confirmPass)){
            Toast.makeText(view.getContext(), passwordNotMatch, Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(this, ForgotPassword_4.class);
            startActivity(i);
            finish();
        }
    }

    public void clickGetStarted(View view) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }
}