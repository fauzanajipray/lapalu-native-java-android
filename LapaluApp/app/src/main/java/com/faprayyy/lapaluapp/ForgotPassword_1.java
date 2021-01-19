package com.faprayyy.lapaluapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword_1 extends AppCompatActivity {

    EditText edEmail;
    String emailEmpty, emailNotValid;
    private Button resetPasswordButton;
    private ProgressBar progressBar;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_1);

        edEmail = findViewById(R.id.edEmail);
        emailEmpty = getResources().getString(R.string.email_empty);
        emailNotValid = getResources().getString(R.string.email_not_valid);
        resetPasswordButton = (Button) findViewById(R.id.btnSend);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
    }

    private void resetPassword(){
        String email = edEmail.getText().toString().trim();

        if (email.isEmpty()){
            edEmail.setError("Email Tidak Ada!");
            edEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edEmail.setError("Tolong masukkan Email yang valid !");
            edEmail.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        fAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull final Task<Void> task) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (task.isSuccessful()){
                            Toast.makeText(ForgotPassword_1.this, "Email Sent Succesfully!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), ForgotPassword_2.class));
                            finish();
                        }else{
                            Toast.makeText(ForgotPassword_1.this, "Your Email has a problem, Try Again!", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    }
                },3000);

            }
        });

    }

    public void toNoHpForgotPass(View view) {
        startActivity(new Intent(getApplicationContext(), ForgotPassword_PhoneNumber.class));
        finish();
    }
}