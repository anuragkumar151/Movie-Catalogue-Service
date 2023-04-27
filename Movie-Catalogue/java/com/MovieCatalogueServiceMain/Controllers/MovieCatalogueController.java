package com.MovieCatalogueServiceMain.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MovieCatalogue.Service.MovieServiceInterface;
import com.MovieCatalogueServiceMain.Entity.MovieCatalogue;
import com.MovieCatalogueServiceMain.Exception.MovieNotFoundException;

@RestController
@RequestMapping("/movie")
public class MovieCatalogueController {
	
	@Autowired
	private MovieServiceInterface movieServiceInterface;

	@GetMapping("/all")
	public ResponseEntity<List<MovieCatalogue>> getAllMovies() throws MovieNotFoundException{
		return ResponseEntity.ok(movieServiceInterface.getAllMovies());
	}

	@GetMapping("/{title}")
	public ResponseEntity<MovieCatalogue> getMovieByTitle(@PathVariable String title) throws MovieNotFoundException {
		return ResponseEntity.ok(movieServiceInterface.getMovieByTitle(title));
	}

	@PutMapping("/{title}")
	public ResponseEntity<MovieCatalogue> updateMovieDetails(@PathVariable String title, @RequestBody MovieCatalogue updatedMovie)
			throws MovieNotFoundException {
		return ResponseEntity.ok(movieServiceInterface.updateMovieDetails(title, updatedMovie));
	}

	@DeleteMapping("/{title}")
	public ResponseEntity<String> deleteMovieByTitle(@PathVariable String title) throws MovieNotFoundException {
		return ResponseEntity.ok(movieServiceInterface.deleteMovieByTitle(title));
	}

	@PostMapping("/add")
	public ResponseEntity<MovieCatalogue> addMovie(@RequestBody MovieCatalogue movie) throws MovieNotFoundException {
		return ResponseEntity.ok(movieServiceInterface.addMovie(movie));
	}

}
