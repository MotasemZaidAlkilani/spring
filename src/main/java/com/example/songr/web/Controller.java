package com.example.songr.web;

import com.example.songr.data.album;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/hello")
     String helloWorld(){

        return "hello";
    }
    @GetMapping("/capitalize/{word}")
    String capitalize(@PathVariable String word,Model model){
  model.addAttribute("word",word);
  return "capitalize";
    }
    @ResponseBody
    @GetMapping("/albums")
    List<album> getAllAlbum(){
  List <album> albums=new ArrayList<>();
  albums.add(new album("never die","john",1000,190,"www.google.com/album1"));
    albums.add(new album("i see the sun","mr. I",250,88,"www.google.com/album2"));
    albums.add(new album("why so serious","wawah man",5456,240,"www.google.com/album3"));
return albums;
    }
}
