package com.example.lyricoffline;

import java.util.ArrayList;

public class Lyric {

    private String title;
    private String artist;
    private ArrayList<Lyric> lyrics;


    public Lyric(String title, String artist){
        this.title = title;
        this.artist = artist;

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

    public Lyric(){

    }

    public ArrayList<Lyric> getLyrics() {
        return lyrics;
    }

    public void setLyrics(ArrayList<Lyric> lyrics) {
        this.lyrics= lyrics;
    }


}
