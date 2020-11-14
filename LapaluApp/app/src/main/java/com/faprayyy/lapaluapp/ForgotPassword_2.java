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

        edCode = findViewById(R.id.edCode);
        codeEmpty = getResources().getString(R.string.code_empty);
        codeMaxLength = getResources().getString(R.string.code_max_length);
    }

    public void clickToNext(View view) {
        if(TextUtils.isEmpty(edCode.getText().toString().trim())){
            Toast.makeText(view.getContext(), codeEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (edCode.length() != 5){
            Toast.makeText(view.getContext(), codeMaxLength, Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(this, ForgotPassword_3.class);
            startActivity(i);
            finish();
        }
    }

}