package com.example.administrator.rxjavatest.bean;

/**
 * Created by Administrator on 2018/3/27.
 */

public class Food {

    public Food(String name, String id, String price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String name;

    public String id;

    public String price;

    @Override
    public String toString() {
        return "name: " + name + "\n" + "id: " + id + "\n" + "price" + price;
    }
}
