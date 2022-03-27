package com.example.songr.data;


import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class song {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private int length;
    private int trackNumber;

    @ManyToOne
    album album;

    public void setAlbum(album album) {
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public com.example.songr.data.album getAlbum() {
        return album;
    }
}





