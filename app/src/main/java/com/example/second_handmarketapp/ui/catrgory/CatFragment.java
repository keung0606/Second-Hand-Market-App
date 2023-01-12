package com.example.second_handmarketapp.ui.catrgory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.second_handmarketapp.CatModel;
import com.example.second_handmarketapp.CatRecAdapter;
import com.example.second_handmarketapp.R;
import com.example.second_handmarketapp.SecondAdapter;
import com.example.second_handmarketapp.SecondMod;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CatFragment extends Fragment {

    FirebaseFirestore db;
    RecyclerView catRec;
    List<CatModel> catModelList;
    CatRecAdapter catRecAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View root = inflater.inflate(R.layout.fragment_cat, container, false);
        db = FirebaseFirestore.getInstance();

        catRec = root.findViewById(R.id.catRec);

        catRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        catModelList = new ArrayList<>();

        catRecAdapter = new CatRecAdapter(getActivity(),catModelList);
        catRec.setAdapter(catRecAdapter);

        db.collection("SecondCatRec")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                CatModel catModel = document.toObject(CatModel.class);
                                catModelList.add(catModel);
                                catRecAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(), "It is error", Toast.LENGTH_SHORT).show();

                        }
                    }
                });


        return  root;
    }

}
