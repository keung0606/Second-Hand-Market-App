package com.example.second_handmarketapp;

public class cartMod {
    String Name;
    String Price;
    String Introduction;
    String Score;
    String Date;
    String Time;

    public cartMod(){

    }

    public cartMod(String Name,String Price,String Introduction,String Score,String Date,String Time){
        this.Name = Name;
        this.Price = Price;
        this.Introduction = Introduction;
        this.Date = Date;
        this.Score = Score;
        this.Time = Time;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
