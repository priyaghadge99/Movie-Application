package com.movie.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.Entity.MovieEntity;
import com.movie.dao.MovieDao;
import com.movie.dto.MovieDto;

@Service
public class MovieServiceimpl implements MovieService {

	@Autowired
	MovieDao movieDao;

	@Autowired
	ModelMapper mapper;

	public MovieDto addMovie(MovieEntity movieEntity) {

		MovieEntity save = movieDao.save(movieEntity);
		MovieDto moviedto = mapper.map(save, MovieDto.class);

		return moviedto;

	}

	public List<MovieDto> getAllMovies() {

		List<MovieEntity> findAll = movieDao.findAll();
		List<MovieDto> maptoDto = Arrays.asList(mapper.map(findAll, MovieDto[].class)) ;
		return maptoDto;
	}

	public MovieDto getMovieName(String name) {
		System.out.println("Inside service === getMovieName");
		MovieEntity findByName = movieDao.findByName(name);
		MovieDto mapToMovieDto = mapper.map(findByName, MovieDto.class);
		return mapToMovieDto;

	}

	public List<MovieDto> getMoviebyPrice(int price) {
		System.out.println("Inside service === getMoviebyPrice");
		List<MovieEntity> findByPrice = movieDao.findByPrice(price);

//		findByPrice.forEach((MovieEntity n)-> mapper.map(findByPrice, n));
		findByPrice.forEach((n) -> System.out.println(n.getPrice()));

		List<MovieDto> movieDtoslist = Arrays.asList(mapper.map(findByPrice, MovieDto[].class));
		int size = movieDtoslist.size();
		System.out.println(size);
		return movieDtoslist;
	}

	public MovieDto deleteMovieByName(String name) {
		MovieEntity findByName = movieDao.findByName(name);
		movieDao.delete(findByName);
		
		MovieDto mapToMovieDto = mapper.map(findByName, MovieDto.class);
		return mapToMovieDto ;
		
	}

	public List<MovieDto> updatePriceInMovie(int price, MovieDto movieDto) {
		List<MovieEntity> findByPrice = movieDao.findByPrice(price);
		for (MovieEntity movieEntity : findByPrice) {
			movieEntity.setPrice(75);
			movieDao.save(mapper.map(movieDto, movieEntity.getClass()));
		}
	    for (MovieEntity movieEntity : findByPrice) {
			System.out.println(movieEntity.getPrice());
		}		
		List<MovieDto> movieDtoasList = Arrays.asList(mapper.map(findByPrice,MovieDto[].class));
		return movieDtoasList;
		
	}

}
