package com.example.second_handmarketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewProducts extends AppCompatActivity {

    ViewAdapter viewAdapter;
    RecyclerView recyclerView;
    List<ViewMod> viewModList;

    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);


        firebaseFirestore = FirebaseFirestore.getInstance();

        String type = getIntent().getStringExtra("type");
        recyclerView = findViewById(R.id.viewRec);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModList = new ArrayList<>();
        viewAdapter = new ViewAdapter(this, viewModList);

        recyclerView.setAdapter(viewAdapter);

        if (type != null && type.equalsIgnoreCase("electronic")) {
            firebaseFirestore.collection("AllSecondProducts").whereEqualTo("type", "electronic").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        ViewMod viewMod = documentSnapshot.toObject(ViewMod.class);
                        viewModList.add(viewMod);
                        viewAdapter.notifyDataSetChanged();

                    }

                }
            });

            }

        if (type != null && type.equalsIgnoreCase("household")) {
            firebaseFirestore.collection("AllSecondProducts").whereEqualTo("type", "household").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        ViewMod viewMod = documentSnapshot.toObject(ViewMod.class);
                        viewModList.add(viewMod);
                        viewAdapter.notifyDataSetChanged();

                    }

                }
            });



                if (type != null && type.equalsIgnoreCase("other")) {
                    firebaseFirestore.collection("AllSecondProducts").whereEqualTo("type", "other").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                                ViewMod viewMod = documentSnapshot.toObject(ViewMod.class);
                                viewModList.add(viewMod);
                                viewAdapter.notifyDataSetChanged();

                            }

                        }
                    });
                }

                    if (type != null && type.equalsIgnoreCase("game")) {
                        firebaseFirestore.collection("AllSecondProducts").whereEqualTo("type", "game").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                                    ViewMod viewMod = documentSnapshot.toObject(ViewMod.class);
                                    viewModList.add(viewMod);
                                    viewAdapter.notifyDataSetChanged();

                                }

                            }
                        });
                    }
        }
    }
}