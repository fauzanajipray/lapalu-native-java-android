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

public class signUp extends AppCompatActivity {

    EditText edEmail, edPassword, edVerifPassword, edFullName;
    String emailEmpty, emailNotValid, passwordEmpty, passwordVerifEmpty, passwordNotMatch, passwordMax, fullNameEmpty;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fAuth = FirebaseAuth.getInstance();

        edFullName = findViewById(R.id.edFullName);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edVerifPassword = findViewById(R.id.edVerifPassword);
        progressBar = findViewById(R.id.progressBar);

        fullNameEmpty = getResources().getString(R.string.fullname_empty);
        emailEmpty = getResources().getString(R.string.email_empty);
        emailNotValid = getResources().getString(R.string.email_not_valid);
        passwordEmpty = getResources().getString(R.string.password_empty);
        passwordVerifEmpty = getResources().getString(R.string.password_verif_empty);
        passwordNotMatch = getResources().getString(R.string.password_not_match);
        passwordMax = getResources().getString(R.string.password_max);

//        // Otomatis Pindah Home Kalau Sudah Login
//        if(fAuth.getCurrentUser() != null ){
//            startActivity(new Intent(getApplicationContext(), Home.class));
//            finish();
//        }
    }

    public void clickSignUp(View view) {
        String email = edEmail.getText().toString().trim();
        String pass = edPassword.getText().toString().trim();
        String confirmPass = edVerifPassword.getText().toString().trim();

        if(TextUtils.isEmpty(edFullName.getText().toString().trim())){
            Toast.makeText(view.getContext(), fullNameEmpty, Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(edEmail.getText().toString().trim())){
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
        else if (pass.length() <= 8){
            Toast.makeText(view.getContext(), passwordMax, Toast.LENGTH_SHORT).show();
        }
        else if (!pass.equals(confirmPass)){
            Toast.makeText(view.getContext(), passwordNotMatch, Toast.LENGTH_SHORT).show();
        }
        else{
            progressBar.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(signUp.this, "User Created", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), SignUpSuccess.class));
                        finish();
                    }else {
                        Toast.makeText(signUp.this, "Error! "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public static boolean isValidEmail (CharSequence email) {
        return  (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}