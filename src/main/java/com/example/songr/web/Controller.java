package com.example.songr.web;

import com.example.songr.data.album;
import com.example.songr.data.albumRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/hello")
    String helloWorld() {

        return "hello";
    }

    @GetMapping("/capitalize/{word}")
    String capitalize(@PathVariable String word, Model model) {
        model.addAttribute("word", word);
        return "capitalize";
    }


    @GetMapping("/albumsJson")
    String getAllAlbum(Model model){
  List <album> albums=new ArrayList<>();
  System.out.print(System.getProperty("user.dif"));
  albums.add(new album("never die","john",1000,190,"https://i.pinimg.com/originals/5b/61/80/5b618062dca30b058454940d7218a3cb.jpg"));
    albums.add(new album("i see the sun","mr. I",250,88,"https://ichef.bbci.co.uk/news/976/cpsprodpb/3ACD/production/_108235051_abbey_road_mitchel_federan.jpg"));
    albums.add(new album("why so serious","wawah man",5456,240,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxBHJVHKOHqhFYt8DZ-V4RD62D7NNE99D-Eg&usqp=CAU"));
    model.addAttribute("albumsList",albums);
    return "albumsJson";
    }

    @Autowired
    albumRepositry albumCRUD;

    @PostMapping("/addAlbum")
    public RedirectView createNewAlbum(@ModelAttribute album albumObject){
        albumCRUD.save(albumObject);
        return new RedirectView("/albums");
    }
    @GetMapping("/album")
        public String getAllAlbums(Model modal){
        modal.addAttribute("albumsList",albumCRUD.findAll());
        return "albums";
        }
        @PostMapping("/getSpecificAlbum")
         RedirectView d(){
          return new RedirectView("albumsJson");
        }
}
