package com.faprayyy.lapaluapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class SaranActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SaranAdapter adapter;
    private ArrayList<SaranModel> saranArrayList;
    FirebaseFirestore db;
    FirebaseAuth fAuth;
    TextView hello;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saran);

        db = FirebaseFirestore.getInstance();

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_saran);
        hello = findViewById(R.id.Hello);
        userId = FirebaseAuth.getInstance().getUid();
        adapter = new SaranAdapter(saranArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SaranActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        DocumentReference docRef = db.collection("users").document(userId);
        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                hello.setText(("Hello " + value.getString("firstName") + "😊"));
            }
        });
    }

    void addData(){
        saranArrayList = new ArrayList<>();

        // Fetch Data from fristore
        db.collection("sarans")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                saranArrayList.add( new SaranModel(
                                        document.getString("pelapor"),
                                        document.getString("judul"),
                                        document.getString("laporan")
                                ));
                            }
                            // kasih tau adapter bahwa data telah berubah
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void toInputSaran(View view) {




        startActivity(new Intent(getApplicationContext(), AddSaran.class));


    }


}