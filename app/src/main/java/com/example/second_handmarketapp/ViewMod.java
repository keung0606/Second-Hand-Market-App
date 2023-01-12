package com.example.second_handmarketapp;

public class ViewMod {
    String name,des,price,score,view_img, type;

    public ViewMod(){

    }

    public ViewMod(String name,String des,String price,String score,String view_img, String type){
        this.name = name;
        this.des = des;
        this.price = price;
        this.score = score;
        this.view_img = view_img;
        this.type = type;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getView_img() {
        return view_img;
    }

    public void setView_img(String view_img) {
        this.view_img = view_img;
    }
}
