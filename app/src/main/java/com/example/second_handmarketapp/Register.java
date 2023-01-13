package com.example.second_handmarketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    Button reg;
    TextView email, name, password;
    FirebaseAuth auth;
    ProgressBar progressBar;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.txt_regEmail);
        name = findViewById(R.id.txt_regName);
        password = findViewById(R.id.txt_regPass);
        reg = findViewById(R.id.btn_reg);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressBar = findViewById(R.id.bar_reg);
        progressBar.setVisibility(View.GONE);


    }

    public void onClickR(View v){

        startActivity(new Intent(Register.this, Login.class));
    }

    public void rreg(View v){
        createUser();

        progressBar.setVisibility(View.VISIBLE);
    }

    private void createUser(){
        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if(TextUtils.isEmpty(userName)){
            Toast.makeText(this, "Name can not be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Email can not be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this, "Password can not be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(userPassword.length() < 6){
            Toast.makeText(this, "Password number should more than 6.", Toast.LENGTH_SHORT).show();
            return;
        }



        auth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            userMod UserMod = new userMod(userName, userEmail, userPassword);
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(UserMod);

                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(Register.this, "Sign up is successful", Toast.LENGTH_SHORT).show();
                        } else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(Register.this, "Sign up is error!" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

}