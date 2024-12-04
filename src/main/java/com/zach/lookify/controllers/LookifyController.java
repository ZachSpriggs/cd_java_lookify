package com.zach.lookify.controllers;

import java.util.*;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.zach.lookify.models.Lookify;
import com.zach.lookify.services.LookifyService;


@Controller
public class LookifyController {

	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
    public String dashboard(Model model) {
        List<Lookify> songs = lookifyService.allSongs();
        model.addAttribute("songs", songs);
        model.addAttribute("artist", new Lookify());
        return "dashboard.jsp";
    }
	
	@RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Lookify song = lookifyService.findSong(id);
        model.addAttribute("song", song);
        return "show.jsp";
    }
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Lookify song) {
		return "new.jsp";
	}
	
	@RequestMapping(value="/songs/create", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            lookifyService.createSong(song);
            return "redirect:/dashboard";
        }
    }
	
	@RequestMapping(value = "/songs/search", method = RequestMethod.GET)
	public String search(@RequestParam(name = "title", required = false) String title, @RequestParam(name = "artist") String artist, @RequestParam(name = "rating", required = false) Integer rating, Model model) {
		List<Lookify> thisArtist = lookifyService.findArtist(artist);
		String myArtist = whichArtist(artist);
		model.addAttribute("artist", myArtist);
		model.addAttribute("songs", thisArtist);
		return "artist.jsp";
	}
	
	@RequestMapping("/topTen")
	public String theTopTen(Model model) {
		List<Lookify> topTenList = lookifyService.findTopTen();
		model.addAttribute("topTen", topTenList);
		return "topTen.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            lookifyService.updateSong(song.getId(),song.getTitle(), song.getArtist(), song.getRating());
            return "redirect:/dashboard";
        }
    }
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        lookifyService.deleteSong(id);
        return "redirect:/dashboard";
    }
	
	public String whichArtist(@Valid @ModelAttribute("artist") String artist) {
		String thisArtist = artist.toString();
		return thisArtist;
	}
	
	
}
