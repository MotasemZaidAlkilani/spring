package com.example.songr.data;


import lombok.*;

import javax.persistence.*;

@Entity
public class song {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private int length;
    private int trackNumber;



    @ManyToOne
    @JoinColumn(name = "album_id")
    album album;


    public song() {
    }

    public song(String title, int length, int trackNumber) {

        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public album getAlbum() {
        return album;
    }

    public void setAlbum(album album) {
        this.album = album;
    }
}





