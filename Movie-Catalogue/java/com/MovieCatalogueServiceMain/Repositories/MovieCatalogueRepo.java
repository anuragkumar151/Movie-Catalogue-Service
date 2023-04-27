package com.MovieCatalogueServiceMain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MovieCatalogueServiceMain.Entity.MovieCatalogue;

public interface MovieCatalogueRepo extends JpaRepository<MovieCatalogue, Integer> {

	// custom finder methods
	MovieCatalogue findByTitle(String title);

}
