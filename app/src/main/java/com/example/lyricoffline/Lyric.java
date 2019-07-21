package com.example.lyricoffline;

import java.util.ArrayList;
import java.util.List;

public class Lyric {

    private int id;
    private String title;
    private String artist;
    private String lyric;


    public Lyric(int id){
        this.id = id;

    }

    public  int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLyric(){
        return lyric;
    }

}
