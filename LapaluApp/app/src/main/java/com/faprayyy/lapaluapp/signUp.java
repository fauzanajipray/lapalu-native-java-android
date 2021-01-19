package com.faprayyy.lapaluapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import io.perfmark.Tag;

public class signUp extends AppCompatActivity {

    EditText edEmail, edPassword, edVerifPassword, edFirstName, edLasName;
    String emailEmpty, emailNotValid, passwordEmpty, passwordVerifEmpty, passwordNotMatch, passwordMax, firstNameEmpty, lastNameEmpty;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseFirestore db;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        edFirstName = findViewById(R.id.edFirstName);
        edLasName = findViewById(R.id.edLastName);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edVerifPassword = findViewById(R.id.edVerifPassword);
        progressBar = findViewById(R.id.progressBar);

        firstNameEmpty = getResources().getString(R.string.first_name_empty);
        lastNameEmpty = getResources().getString(R.string.last_name_empty);
        emailEmpty = getResources().getString(R.string.email_empty);
        emailNotValid = getResources().getString(R.string.email_not_valid);
        passwordEmpty = getResources().getString(R.string.password_empty);
        passwordVerifEmpty = getResources().getString(R.string.password_verif_empty);
        passwordNotMatch = getResources().getString(R.string.password_not_match);
        passwordMax = getResources().getString(R.string.password_max);

//        // Otomatis Pindah Home Kalau Sudah Login
        if(fAuth.getCurrentUser() != null ){
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        }
    }

    public void clickSignUp(View view) {
        final String firstName = edFirstName.getText().toString().trim();
        final String lastName = edLasName.getText().toString().trim();
        final String email = edEmail.getText().toString().trim();
        String pass = edPassword.getText().toString().trim();
        String confirmPass = edVerifPassword.getText().toString().trim();

        if(TextUtils.isEmpty(firstName)){
            Toast.makeText(view.getContext(), firstNameEmpty, Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(lastName)){
            Toast.makeText(view.getContext(), lastNameEmpty, Toast.LENGTH_SHORT).show();
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
                        //Toast.makeText(signUp.this, "User Created", Toast.LENGTH_SHORT).show();
                        userID = fAuth.getCurrentUser().getUid();
                        DocumentReference documentReference = db.collection("users").document(userID);
                        Map<String, Object> user = new HashMap<>();
                        user.put("firstName", firstName);
                        user.put("lastName", lastName);
                        user.put("email", email);

                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG", "On Success: user profile is created for " + userID );
                                startActivity(new Intent(getApplicationContext(), SignUpSuccess.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("TAG", "on Failure : " + e.toString());
                            }
                        });

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

    public void clickLogin(View view) {
        Intent i = new Intent(signUp.this, Login.class);
        startActivity(i);
        finish();
    }
}