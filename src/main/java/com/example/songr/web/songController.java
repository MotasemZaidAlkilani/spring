package com.example.songr.web;


import com.example.songr.data.song;
import com.example.songr.data.songRepsoitry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class songController {

    private final songRepsoitry songRepsoitry;

    public songController(songRepsoitry songRepsoitry) {
        this.songRepsoitry = songRepsoitry;
    }

    @ResponseBody
    @PostMapping("/songs")
    song addNewSong(@RequestBody song song){
     return songRepsoitry.save(song);
    }
    @ResponseBody
    @GetMapping("/songs")
    List<song> getAllSong(){
        return songRepsoitry.findAll();
    }
    @ResponseBody
    @GetMapping("/songs/{id}")
    song getSongById(@PathVariable Integer id){
        return songRepsoitry.getById(id);
    }



}
