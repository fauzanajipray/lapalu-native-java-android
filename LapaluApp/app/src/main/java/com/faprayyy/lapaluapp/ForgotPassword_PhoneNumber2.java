package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword_PhoneNumber2 extends AppCompatActivity {

    EditText edCode;
    String codeEmpty, codeMaxLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password__phone_number2);
        edCode = findViewById(R.id.edCode);
    }

    public void clickToNext(View view) {
        if(TextUtils.isEmpty(edCode.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Kode tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        else if (edCode.length() != 5){
            Toast.makeText(view.getContext(), "Kode harus ada 5", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(this, ForgotPassword_3.class);
            startActivity(i);
            finish();
        }
    }
}