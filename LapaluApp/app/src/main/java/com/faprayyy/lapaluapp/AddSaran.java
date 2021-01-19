package com.faprayyy.lapaluapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AddSaran extends AppCompatActivity {

    EditText edJudul, edNama, edEmail, edLaporan;
    Button btnSave;
    String userId, emailEmpty;
    ProgressDialog pd;
    FirebaseFirestore db;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_saran);

        edJudul = findViewById(R.id.edJudul);
        edLaporan = findViewById(R.id.edLaporan);
        edNama = findViewById(R.id.edNama);
        edEmail = findViewById(R.id.edEmail);
        btnSave = findViewById(R.id.btnSave);
        emailEmpty = getResources().getString(R.string.email_empty);

        pd = new ProgressDialog(this);
        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();

        DocumentReference docRef = db.collection("users").document(userId);
        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                edNama.setText((value.getString("firstName") +" "+ value.getString("lastName")));
                edEmail.setText(value.getString("email"));
            }
        });

    }

    public void clickSave(View view) {
        String judul = edJudul.getText().toString().trim();
        String laporan = edLaporan.getText().toString().trim();
        String pelapor = edNama.getText().toString().trim();
        String email = edEmail.getText().toString().trim();
        Date currentTime = Calendar.getInstance().getTime();

        if(TextUtils.isEmpty(judul)){
            Toast.makeText(view.getContext(), "Judul masih kosong!", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(email)){
            Toast.makeText(view.getContext(), emailEmpty, Toast.LENGTH_SHORT).show();
        }
        else {
            uploudData(pelapor, email, judul, laporan, currentTime);
        }

    }

    private void uploudData(String pelapor, String email, String judul, String laporan, Date currentTime) {
        pd.setTitle("Adding Data to Database");
        pd.show();

        final String id = UUID.randomUUID().toString();
        Map<String, Object> saran = new HashMap<>();
        saran.put("pelapor", pelapor);
        saran.put("email", email);
        saran.put("judul", judul);
        saran.put("laporan", laporan);
        saran.put("dibuatTgl", currentTime);

        DocumentReference docRef = db.collection("sarans").document(id);

        docRef.set(saran).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                pd.dismiss();
                Toast.makeText(AddSaran.this, "Saran telah terkirim!", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "On Success: Saran telah dibuat untuk " + id );
                startActivity(new Intent(getApplicationContext(), SaranActivity.class));
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