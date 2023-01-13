package com.example.second_handmarketapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.bar_home);
        progressBar.setVisibility(View.GONE);

        //if(auth.getCurrentUser() != null){progressBar.setVisibility(View.VISIBLE);
            //startActivity((new Intent(MainActivity.this,frontPage.class)));

            //Toast.makeText(this, "Already login.", Toast.LENGTH_SHORT).show();
            //finish();
        //}


    }

    public void homeLog(View v){

        startActivity(new Intent(MainActivity.this, Login.class));
    }

    public void homeReg(View v){

        startActivity(new Intent(MainActivity.this, Register.class));
    }

    public void onClick(View v){

        startActivity(new Intent(MainActivity.this, chatBox.class));
    }


}