package com.MovieCatalogue.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MovieCatalogueServiceMain.Entity.MovieCatalogue;

@Service
public interface MovieServiceInterface {
	
	public List<MovieCatalogue> getAllMovies();
	public MovieCatalogue getMovieByTitle(String title);
	public MovieCatalogue updateMovieDetails(String title, MovieCatalogue updatedMovie);
	public String deleteMovieByTitle(String title);
	public MovieCatalogue addMovie(MovieCatalogue movie);
	
}