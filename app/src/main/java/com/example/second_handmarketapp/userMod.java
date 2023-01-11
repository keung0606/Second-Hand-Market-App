package com.example.second_handmarketapp;

public class userMod {
    String  name, email, password;

    public userMod(){

    }

    public userMod(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
