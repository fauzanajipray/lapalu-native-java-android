package com.faprayyy.lapaluapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText edEmail, edPassword;
    String emailEmpty, emailNotValid, passwordEmpty, formEmpty;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        emailEmpty = getResources().getString(R.string.email_empty);
        emailNotValid = getResources().getString(R.string.email_not_valid);
        passwordEmpty = getResources().getString(R.string.password_empty);
        formEmpty = getResources().getString(R.string.form_empty);

        // Otomatis Pindah Home Kalau Sudah Login
        if(fAuth.getCurrentUser() != null ){
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        }
    }

    public void clickLogin(View view) {

        String email = edEmail.getText().toString().trim();
        String pass = edPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)
                && TextUtils.isEmpty(pass)) {
            Toast.makeText(view.getContext(), formEmpty, Toast.LENGTH_SHORT).show();
            edEmail.setFocusable(true);
        }

        else if(TextUtils.isEmpty(email)){
            Toast.makeText(view.getContext(), emailEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (!isValidEmail(email)){
            Toast.makeText(view.getContext(), emailNotValid, Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(pass)){
            Toast.makeText(view.getContext(), passwordEmpty, Toast.LENGTH_SHORT).show();
        }
        else {
            progressBar.setVisibility(View.VISIBLE);

            fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Login.this, "Logged in Successfully ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        finish();
                    } else {
                        Toast.makeText(Login.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }

    }

    public void clickSignUp(View view) {
        Intent i = new Intent(this, signUp.class);
        startActivity(i);
    }

    public void clickForgot(View view) {
        Intent i = new Intent(this, ForgotPassword_1.class);
        startActivity(i);
    }

    public static boolean isValidEmail (CharSequence email) {
        return  (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}