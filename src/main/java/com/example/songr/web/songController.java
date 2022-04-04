package com.example.songr.web;


import com.example.songr.data.album;
import com.example.songr.data.albumRepositry;
import com.example.songr.data.song;
import com.example.songr.data.songRepsoitry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

@Controller
public class songController {

    private final songRepsoitry songRepsoitry;

    public songController(songRepsoitry songRepsoitry, albumRepositry albumRepositry) {
        this.songRepsoitry = songRepsoitry;

        this.albumRepositry = albumRepositry;
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
    private final albumRepositry albumRepositry;
    @RequestMapping(value = "/addSongToAlbum", method = RequestMethod.POST)
    public String addSongToAlbum(@RequestParam int album_id,
                                @RequestParam String song_title,
                                 @RequestParam int song_length,
                                 @RequestParam int song_trackNumber,
                                Model model) {

            if (albumRepositry.existsById(album_id)) {
                song newSong = new song(song_title, song_length, song_trackNumber);

                try {
                    album newAlbum=albumRepositry.findByid(album_id);
                    newSong.setAlbum(newAlbum);
                    String doneMessage = "added to your profile";
                    model.addAttribute("message", doneMessage);
                    albumRepositry.save(newAlbum);
                    songRepsoitry.save(newSong);
                } catch (Exception e) {
                    String ErrorMessage = "Error";
                    model.addAttribute("message", ErrorMessage);
                }

            } else {
                String emptyMessage = "error";
                model.addAttribute("message", emptyMessage);

            }

        return "index";
    }


}
