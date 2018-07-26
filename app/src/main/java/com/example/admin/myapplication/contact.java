package com.example.admin.myapplication;

import android.widget.TextView;

public class contact {
    private int img;
    private String texName;
    private String texNum;

    public contact(int img, String texName, String texNum) {
        this.img = img;
        this.texName = texName;
        this.texNum = texNum;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTexName() {
        return texName;
    }

    public void setTexName(String texName) {
        this.texName = texName;
    }

    public String getTexNum() {
        return texNum;
    }

    public void setTexNum(String texNum) {
        this.texNum = texNum;
    }
}
