package com.example.hlchen.sports_app.Class;

import android.graphics.Bitmap;

/**
 * Created by Hlchen on 2018/3/15.
 */

public class Game_Data_Class {
    Bitmap Team_Ui;
    String Team_Name;
    String Time;
    String Place;

    public Game_Data_Class(Bitmap team_Ui, String team_Name, String time, String place) {
        Team_Ui = team_Ui;
        Team_Name = team_Name;
        Time = time;
        Place = place;
    }

    public Bitmap getTeam_Ui() {
        return Team_Ui;
    }

    public void setTeam_Ui(Bitmap team_Ui) {
        Team_Ui = team_Ui;
    }

    public String getTeam_Name() {
        return Team_Name;
    }

    public void setTeam_Name(String team_Name) {
        Team_Name = team_Name;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }
}
