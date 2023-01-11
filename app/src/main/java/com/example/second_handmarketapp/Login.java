package com.example.second_handmarketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button log;
    EditText email, password;
    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        progressBar = findViewById(R.id.bar_log);
        progressBar.setVisibility(View.GONE);
        email = findViewById(R.id.txt_logEmail);
        password = findViewById(R.id.txt_logPass);
        log = findViewById(R.id.btn_log);
        auth = FirebaseAuth.getInstance();



    }

    public void onClickL(View v){

        startActivity(new Intent(Login.this, Register.class));
    }



    public void llog(View v){
        logUser();

        progressBar.setVisibility(View.VISIBLE);
    }

    public void logUser(){
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();


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

        auth.signInWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);

                            Toast.makeText(Login.this, "Login success!", Toast.LENGTH_SHORT).show();
                        } else {
                            progressBar.setVisibility(View.GONE);

                            Toast.makeText(Login.this, "Login error!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

}