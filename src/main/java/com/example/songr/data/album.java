package com.example.songr.data;

<<<<<<< HEAD
import lombok.*;

import javax.persistence.*;
import java.util.Set;
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
=======
import org.hibernate.type.ImageType;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

>>>>>>> 6ac6d6004f6552b1cc77daf0fb2363fadd6921ca
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

<<<<<<< HEAD
=======
    public album() {
    }

    public album(String title, String artist, int song_count, int length, String image_url)  {
        this.title = title;
        this.artist = artist;
        this.song_count = song_count;
        this.length = length;
        this.image_url=image_url;

    }
>>>>>>> 6ac6d6004f6552b1cc77daf0fb2363fadd6921ca

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
