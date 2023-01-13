package com.example.second_handmarketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class InfoProduct extends AppCompatActivity {

    ImageView info_img;
    TextView price,score,des;
    Button add;
    ViewMod viewMod = null;

    FirebaseFirestore f;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_product);

        final Object object = getIntent().getSerializableExtra("info");

        if(object instanceof ViewMod){
            viewMod = (ViewMod) object;

        }


        price = findViewById(R.id.info_price);
        score = findViewById(R.id.info_score);
        des= findViewById(R.id.info_des);
        info_img = findViewById(R.id.info_img);

        f = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        if(viewMod != null){
            Glide.with(getApplicationContext()).load(viewMod.getView_img()).into(info_img);
            score.setText(viewMod.getScore());
            des.setText(viewMod.getDes());
            price.setText("The price is $" + viewMod.getPrice());


        }



        add = findViewById(R.id.btn_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCart();

            }
        });






    }

    private void addCart() {
        String saveDate, saveTime;
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat Date = new SimpleDateFormat("MM dd,yyyy");
        saveDate = Date.format(calendar.getTime());

        SimpleDateFormat Time = new SimpleDateFormat("HH:mm:ss a");
        saveTime = Date.format(calendar.getTime());

        final HashMap<String,Object> hashMap = new HashMap<>();

        hashMap.put("Name",viewMod.getName());
        hashMap.put("Price",viewMod.getPrice());
        hashMap.put("Score",viewMod.getScore());
        hashMap.put("Introduction",viewMod.getDes());
        hashMap.put("Date",saveDate);
        hashMap.put("Time",saveTime);

        f.collection("TheCart").document(auth.getCurrentUser().getUid())
                .collection("User").add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(InfoProduct.this, "Added",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

    }
}