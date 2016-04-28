package com.example.acer.mooclayout;

/**
 * Created by acer on 2016/4/3.
 */
public class Fruit {
    private String name;
    private int imageID;
    public Fruit(String name, int imageID){
        this.name = name;
        this.imageID = imageID;
    }

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }
}
