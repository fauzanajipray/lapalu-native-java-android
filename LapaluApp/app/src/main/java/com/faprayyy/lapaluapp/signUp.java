package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    EditText edEmail, edPassword, edVerifPassword;
    String emailEmpty, emailNotValid, passwordEmpty, passwordVerifEmpty, passwordNotMatch, passwordMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edVerifPassword = findViewById(R.id.edVerifPassword);

        emailEmpty = getResources().getString(R.string.email_empty);
        emailNotValid = getResources().getString(R.string.email_not_valid);
        passwordEmpty = getResources().getString(R.string.password_empty);
        passwordVerifEmpty = getResources().getString(R.string.password_verif_empty);
        passwordNotMatch = getResources().getString(R.string.password_not_match);
        passwordMax = getResources().getString(R.string.password_max);
    }

    public void clickSignUp(View view) {
        String newPass = edPassword.getText().toString().trim();
        String confirmPass = edVerifPassword.getText().toString().trim();

        if(TextUtils.isEmpty(edEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), emailEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (!isValidEmail(edEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), emailNotValid, Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(edPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), passwordEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(edVerifPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), passwordVerifEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (newPass.length() <= 8){
            Toast.makeText(view.getContext(), passwordMax, Toast.LENGTH_SHORT).show();
        }
        else if (!newPass.equals(confirmPass)){
            Toast.makeText(view.getContext(), passwordNotMatch, Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(this, SignUpSuccess.class);
            startActivity(i);
            finish();
        }
    }

    public static boolean isValidEmail (CharSequence email) {
        return  (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}