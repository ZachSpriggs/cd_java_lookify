package com.zach.lookify.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zach.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	// retrieves all songs
	List<Lookify> findAll();
	
	// searches by artist
	List<Lookify> findByArtistContaining(String search); 
	
	// searches by song
	List<Lookify> findByTitleContaining(String search);
	
	List<Lookify> findTop10ByOrderByRatingDesc();
	
}
