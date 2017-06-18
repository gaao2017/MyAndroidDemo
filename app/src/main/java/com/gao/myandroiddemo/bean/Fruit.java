package com.gao.myandroiddemo.bean;

/**
 * Created by gao on 2017/6/15.
 * 一个实体类
 */

public class Fruit {
    public String name; //水果的名字
    private int imageId; //水果对应图片的 id

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
