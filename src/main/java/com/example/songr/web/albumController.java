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
    public RedirectView createNewAlbum(@RequestParam String title,@RequestParam String artist,
                                       @RequestParam int song_count,@RequestParam int length,
                                       @RequestParam String image_url,
                                       Model model){
        album newAlbum=new album(title,artist,song_count,length,image_url);
        albumCRUD.save(newAlbum);
        return new RedirectView("/albums");
    }
    @GetMapping("/albums")
        public String getAllAlbums(Model modal){
        modal.addAttribute("albumsList",albumCRUD.findAll());
        return "albums";
        }
    @ResponseBody
    @RequestMapping(value="/albums/{id}",method = RequestMethod.GET)
    public album getbyIdAlbum(@PathVariable int id){
        return albumCRUD.findByid(id);
    }
    @ResponseBody
    @GetMapping("/album")
    List<album> getAllAlbums(){
        return (List<album>) albumCRUD.findAll();

    }
    private final songRepsoitry songRepsoitry;


}
