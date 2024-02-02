package com.movie.service;

import java.util.List;

import com.movie.Entity.MovieEntity;
import com.movie.dto.MovieDto;

public interface MovieService {
	
  public MovieDto addMovie(MovieEntity movieEntity);
  public List<MovieDto> getAllMovies();
  public MovieDto getMovieName(String name) ;
  public List<MovieDto> getMoviebyPrice(int price);
  public MovieDto deleteMovieByName(String name);

}
