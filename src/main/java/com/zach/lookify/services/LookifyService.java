package com.zach.lookify.services;

import java.util.*;
import org.springframework.stereotype.Service;
import com.zach.lookify.models.Lookify;
import com.zach.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {

	private final LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public List<Lookify> allSongs(){
		return lookifyRepository.findAll();
	}
	
	public Lookify createSong(Lookify lookify) {
		return lookifyRepository.save(lookify);
	}
	
	public Lookify updateSong(Long id, String title, String artist, int rating) {
		Lookify song = findSong(id);
		song.setTitle(title);
		song.setArtist(artist);
		song.setRating(rating);
		return lookifyRepository.save(song);
	}
	
	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
	}
	
	public Lookify findSong(Long id) {
		Optional<Lookify> optionalSong = lookifyRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	public List<Lookify> findArtist(String artist) {
		return lookifyRepository.findByArtistContaining(artist);
	}
	
	public List<Lookify> findTopTen(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	
}
