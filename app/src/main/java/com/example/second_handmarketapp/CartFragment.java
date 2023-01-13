package com.example.second_handmarketapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {

    RecyclerView recyclerView;
    CartAdapter cartAdapter;
    List<cartMod> cartModList;

    FirebaseAuth auth;
    FirebaseFirestore f;

    public CartFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cart, container, false);

        f = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        recyclerView = root.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));

        cartModList = new ArrayList<>();
        cartAdapter = new CartAdapter(getActivity(),cartModList);
        recyclerView.setAdapter(cartAdapter);

        f.collection("TheCart").document(auth.getCurrentUser().getUid())
                        .collection("User").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if(task.isSuccessful()){
                            for(DocumentSnapshot documentSnapshot: task.getResult().getDocuments()){
                                cartMod cartMod = documentSnapshot.toObject(cartMod.class);
                                cartModList.add(cartMod);
                                cartAdapter.notifyDataSetChanged();
                            }
                        }

                    }
                });




        return root;
    }
}