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

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSecImg() {
        return secImg;
    }

    public void setSecImg(String secImg) {
        this.secImg = secImg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
