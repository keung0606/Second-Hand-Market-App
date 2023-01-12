package com.example.second_handmarketapp;

public class CatModel {

    String name,des,dis,cat_img;

    public CatModel(){

    }

    public CatModel(String name,String des,String dis,String cat_img){
        this.name = name;
        this.des = des;
        this.dis = dis;
        this.cat_img = cat_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCat_img() {
        return cat_img;
    }

    public void setCat_img(String cat_img) {
        this.cat_img = cat_img;
    }
}
