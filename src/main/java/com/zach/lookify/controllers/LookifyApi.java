package com.zach.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zach.lookify.models.Lookify;
import com.zach.lookify.services.LookifyService;

@RestController
public class LookifyApi {

private final LookifyService lookifyService;
	
    public LookifyApi(LookifyService lookifyService){
        this.lookifyService = lookifyService;
    }
    @RequestMapping("/api/song")
    public List<Lookify> index() {
        return lookifyService.allSongs();
    }
    
    @RequestMapping(value="/api/song", method=RequestMethod.POST)
    public Lookify create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") int rating) {
        Lookify song = new Lookify(title, artist, rating);
        return lookifyService.createSong(song);
    }
    
    @RequestMapping("/api/song/{id}")
    public Lookify show(@PathVariable("id") Long id) {
        Lookify song = lookifyService.findSong(id);
        return song;
    }
    
    @RequestMapping(value="/api/song/{id}", method=RequestMethod.PUT)
    public Lookify update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") int rating) {
        Lookify song = lookifyService.updateSong(id, title, artist, rating);
        return song;
    }
    
    @RequestMapping(value="/api/song/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	lookifyService.deleteSong(id);
    }
}
