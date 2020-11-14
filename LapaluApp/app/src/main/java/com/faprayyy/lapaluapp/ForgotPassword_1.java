package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword_1 extends AppCompatActivity {

    EditText edEmail;
    String emailEmpty, emailNotValid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_1);

        edEmail = findViewById(R.id.edEmail);
        emailEmpty = getResources().getString(R.string.email_empty);
        emailNotValid = getResources().getString(R.string.email_not_valid);
    }

    public void clickToSend(View view) {

        if(TextUtils.isEmpty(edEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), emailEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (!isValidEmail(edEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), emailNotValid, Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(this, ForgotPassword_2.class);
            startActivity(i);
            finish();
        }
    }

    public static boolean isValidEmail (CharSequence email) {
        return  (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

}