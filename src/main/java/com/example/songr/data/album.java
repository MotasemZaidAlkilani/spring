package com.example.songr.data;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class album {
    @Setter(value = AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;
   private  String title;
   private String artist;
   private int song_count;
   private int length;
   private String image_url;

   @OneToMany(mappedBy = "album")
   Set<song> songs;


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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSong_count() {
        return song_count;
    }

    public void setSong_count(int song_count) {
        this.song_count = song_count;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Set<song> getSongs() {
        return songs;
    }

    public void setSongs(song songs) {
        this.songs.add(songs);
    }
}
