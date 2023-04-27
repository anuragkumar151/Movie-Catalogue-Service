package com.MovieCatalogue.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieCatalogueServiceMain.Entity.MovieCatalogue;
import com.MovieCatalogueServiceMain.Exception.MovieNotFoundException;
import com.MovieCatalogueServiceMain.Repositories.MovieCatalogueRepo;

@Service
public class MovieService implements MovieServiceInterface
{
	
	@Autowired
	private MovieCatalogueRepo catalogueRepo;
	
	//GET ALL MOVIES
	public List<MovieCatalogue> getAllMovies() {
		List<MovieCatalogue> movies = catalogueRepo.findAll();
		if (movies.isEmpty()) {
			throw new MovieNotFoundException("No movies found");
		}
		return movies;
	}
	
	//GET MOVIE BY TITLE
	public MovieCatalogue getMovieByTitle(String title) {
		MovieCatalogue movie = catalogueRepo.findByTitle(title);
		if (movie == null) {
			throw new MovieNotFoundException("Movie not found for title: " + title);
		}
		return movie;
	}
	
	//UPDATE MOVIE BY TITLE
	public MovieCatalogue updateMovieDetails(String title, MovieCatalogue updatedMovie)  {
	MovieCatalogue movie = catalogueRepo.findByTitle(title);
	if (movie == null) {
		throw new MovieNotFoundException("Movie not found for title: " + title);
	}
	movie.setDescription(updatedMovie.getDescription());
	movie.setGenre(updatedMovie.getGenre());
	movie.setImdbRating(updatedMovie.getImdbRating());
	MovieCatalogue savedMovie = catalogueRepo.save(movie);
	return savedMovie;
}
	
	//TO DELETE
	public String deleteMovieByTitle(String title) {
		MovieCatalogue movie = catalogueRepo.findByTitle(title);
		if (movie == null) {
			throw new MovieNotFoundException("Movie not found for title: " + title);
		}
		catalogueRepo.delete(movie);
		return ("Movie with title " + title + " deleted successfully");
	}
	
	//TO ADD MOVIE
	public MovieCatalogue addMovie(MovieCatalogue movie) {
		if(movie.getImdbRating()>10) {
			throw new MovieNotFoundException("Invalid Rating");
		}
		
		return catalogueRepo.save(movie);
	}
}
