package com.faprayyy.lapaluapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserProfileEdit extends AppCompatActivity {

    Button btnSave;
    EditText edFirstName, edLastName, edNoHp, edAlamat;
    FirebaseFirestore db;
    FirebaseAuth fAuth;
    String userId, firstNameEmpty, lastNameEmpty;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_edit);

        btnSave = findViewById(R.id.btnSave);
        edFirstName = findViewById(R.id.edFirstName);
        edLastName = findViewById(R.id.edLastName);
        edNoHp = findViewById(R.id.edNoHp);
        edAlamat = findViewById(R.id.edAlamat);
        pb = findViewById(R.id.progressBar);

        firstNameEmpty = getResources().getString(R.string.first_name_empty);
        lastNameEmpty = getResources().getString(R.string.last_name_empty);

        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();

        DocumentReference docRef = db.collection("users").document(userId);
        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                edFirstName.setText(value.getString("firstName"));
                edLastName.setText(value.getString("lastName"));
                edNoHp.setText(value.getString("noHp"));
                edAlamat.setText(value.getString("alamat"));
            }
        });
    }

    public void clickSave(View view) {
        final String firstName = edFirstName.getText().toString().trim();
        final String lastName = edLastName.getText().toString().trim();
        final String alamat = edAlamat.getText().toString().trim();
        final String nohp = edNoHp.getText().toString().trim();

        if(TextUtils.isEmpty(firstName)){
            Toast.makeText(view.getContext(), firstNameEmpty, Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(lastName)){
            Toast.makeText(view.getContext(), lastNameEmpty, Toast.LENGTH_SHORT).show();
        }
        else {
            pb.setVisibility(View.VISIBLE);

            updateProfile(firstName, lastName, nohp, alamat);
        }
    }

    private void updateProfile(String firstName, String lastName, String nohp, String alamat) {

//        DocumentReference docRef = db.collection("sarans").document(userId);
//        docRef.update("firstName", firstName);

        Map<String, Object> user = new HashMap<>();
        user.put("firstName", firstName);
        user.put("lastName", lastName);
        user.put("noHp", nohp);
        user.put("alamat", alamat);

        DocumentReference docRef = db.collection("users").document(userId);

        docRef.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                pb.setVisibility(View.INVISIBLE);
                Toast.makeText(UserProfileEdit.this, "Data telah terupdate!", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "On Success: Data telah diupdate untuk " + userId );
                startActivity(new Intent(getApplicationContext(), UserProfileActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("TAG", "on Failure : " + e.toString());
            }
        });

    }
}