package com.example.second_handmarketapp;

public class SecondMod {

    String name,des,secImg,score,dis, type;

    public SecondMod(){

    }

    public SecondMod(String name,String des,String secImg,String score,String dis, String type) {
        this.name = name;
        this.des = des;
        this.score = score;
        this.dis = dis;
        this.secImg = secImg;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public String getDis() {
        return dis;
    }

    public String getScore() {
        return score;
    }

    public String getSecImg() {
        return secImg;
    }

    public String getType() {
        return type;
    }
}
