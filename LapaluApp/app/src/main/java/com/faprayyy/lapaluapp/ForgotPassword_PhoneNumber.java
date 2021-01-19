package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword_PhoneNumber extends AppCompatActivity {

    EditText edPhoneNumber;

    String emailEmpty, emailNotValid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password__phone_number);

        edPhoneNumber = findViewById(R.id.edPhoneNumber);
    }

    public void toPhoneNumberReset(View view) {
        if(TextUtils.isEmpty(edPhoneNumber.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Phone number tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(this, ForgotPassword_3.class);
            startActivity(i);
            finish();
        }
    }
}