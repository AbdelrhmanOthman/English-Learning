package com.abdelrhman.abdo.learn_english;

/**
 * Created by Dell on 19/04/18.
 */

public class listitemOnline {
    public String Title;
    public String sound;

    public listitemOnline(String title,String sound) {
        Title = title;
        this.sound = sound;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }



    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}




