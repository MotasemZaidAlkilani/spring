package com.example.songr.web;

import com.example.songr.data.album;
import com.example.songr.data.albumRepositry;
import com.example.songr.data.song;
import com.example.songr.data.songRepsoitry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Controller
public class albumController {

    public albumController(com.example.songr.data.songRepsoitry songRepsoitry) {
        this.songRepsoitry = songRepsoitry;
    }

    @GetMapping("/hello")
    String helloWorld() {

        return "hello";
    }

    @GetMapping("/capitalize/{word}")
    String capitalize(@PathVariable String word, Model model) {
        model.addAttribute("word", word);
        return "capitalize";
    }

    //    @ResponseBody
//    @GetMapping("/albums")
//    List<album> getAllAlbum(){
//  List <album> albums=new ArrayList<>();
//  albums.add(new album("never die","john",1000,190,"www.google.com/album1"));
//    albums.add(new album("i see the sun","mr. I",250,88,"www.google.com/album2"));
//    albums.add(new album("why so serious","wawah man",5456,240,"www.google.com/album3"));
//return albums;
//    }

    @Autowired
    albumRepositry albumCRUD;

    @PostMapping("/addAlbum")
    public RedirectView createNewAlbum(@ModelAttribute album albumObject){
        albumCRUD.save(albumObject);
        return new RedirectView("/albums");
    }
    @GetMapping("/albums")
        public String getAllAlbums(Model modal){
        modal.addAttribute("albumsList",albumCRUD.findAll());
        return "albums";
        }
    @ResponseBody
    @GetMapping("/album")
    List<album> getAllAlbums(){
        return (List<album>) albumCRUD.findAll();

    }
    private final songRepsoitry songRepsoitry;
    @ResponseBody
    @PostMapping("/albums/{id}")
    RedirectView addSongToAlbum(@PathVariable Integer id ,@RequestBody song song){
        album album= albumCRUD.findById(id).orElseThrow();
        album.setSongs(song);
        albumCRUD.save(album);
        return new RedirectView("/album");

    }
}
