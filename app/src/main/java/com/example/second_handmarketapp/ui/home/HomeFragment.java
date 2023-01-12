package com.example.second_handmarketapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.second_handmarketapp.HomeAdapter;
import com.example.second_handmarketapp.R;
import com.example.second_handmarketapp.SecondAdapter;
import com.example.second_handmarketapp.SecondCat;
import com.example.second_handmarketapp.SecondMod;
import com.example.second_handmarketapp.databinding.FragmentHomeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FirebaseFirestore db;

    List<SecondMod> secondModList;
    SecondAdapter secondAdapter;

    RecyclerView secondRec, secondCatRec;

    List<SecondCat> secondCatList;
    HomeAdapter homeAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        db = FirebaseFirestore.getInstance();
        secondRec = root.findViewById(R.id.pop_list);
        secondCatRec =root.findViewById(R.id.pop_catlist);

        secondRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        secondModList = new ArrayList<>();

        secondAdapter = new SecondAdapter(getActivity(),secondModList);
        secondRec.setAdapter(secondAdapter);

        db.collection("SecondHandProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                SecondMod secondMod = document.toObject(SecondMod.class);
                                secondModList.add(secondMod);
                                secondAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(), "It is error", Toast.LENGTH_SHORT).show();

                        }
                    }
                });


        secondCatRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        secondCatList = new ArrayList<>();

        homeAdapter = new HomeAdapter(getActivity(),secondCatList);
        secondCatRec.setAdapter(homeAdapter);

        db.collection("SecondProductsCat")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                SecondCat secondCat = document.toObject(SecondCat.class);
                                secondCatList.add(secondCat);
                                homeAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(), "It is error", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        return root;
    }
}