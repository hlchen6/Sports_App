package com.example.hlchen.sports_app.Class;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hlchen on 2018/3/15.
 */

public class Tyq_Class {
    private Bitmap tx;
    private String User_Name;
    private Bitmap pic;
    private String User_nr;
    private String Time;

    public Bitmap getTx() {
        return tx;
    }

    public void setTx(Bitmap tx) {
        this.tx = tx;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public Bitmap getPic() {
        return pic;
    }

    public void setPic(Bitmap pic) {
        this.pic = pic;
    }

    public String getUser_nr() {
        return User_nr;
    }

    public void setUser_nr(String user_nr) {
        User_nr = user_nr;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public Tyq_Class(Bitmap tx, String user_Name, Bitmap pic, String user_nr, String time) {

        this.tx = tx;
        User_Name = user_Name;
        this.pic = pic;
        User_nr = user_nr;
        Time = time;
    }
}
