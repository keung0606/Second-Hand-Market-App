package com.example.second_handmarketapp;

public class SecondCat {
    String name,catImg,type;

    public SecondCat(){

    }

    public SecondCat(String name,String secImg,String type){
        this.name = name;
        this.catImg = secImg;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatImg() {
        return catImg;
    }

    public void setSecImg(String secImg) {
        this.catImg = secImg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
