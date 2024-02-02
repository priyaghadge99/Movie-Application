package com.movie.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.Entity.MovieEntity;
import com.movie.dao.MovieDao;
import com.movie.dto.MovieDto;
import com.movie.service.MovieServiceimpl;

@RestController
//@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieServiceimpl movieServiceimpl;

	@Autowired
	MovieDao dao;

//	@Autowired
//	ModelMapper mapper;

	@PostMapping("/addmovie")
	public ResponseEntity<MovieDto> addMovie(@RequestBody MovieEntity movieEntity) {

		System.out.println("ticketId  ::  " + movieEntity.getId());
		MovieDto movieDto = movieServiceimpl.addMovie(movieEntity);
		return new ResponseEntity<MovieDto>(movieDto, HttpStatusCode.valueOf(200));

	}

	@GetMapping("/healthcheck")
	public String check() {
		System.out.println("inside healthe chcek");
		return "Code is working correct";
	}

	@GetMapping("/getallmovie")
	public ResponseEntity<List<MovieDto>>  getAllMovie(){
		List<MovieDto> allMovie = movieServiceimpl.getAllMovies();
		return new ResponseEntity<List<MovieDto>>(allMovie, HttpStatus.FOUND);
	}

	@GetMapping("/getmovie/{name}")
	public ResponseEntity<MovieDto> getMovieByname(@PathVariable("name") String name) {
		System.out.println("Inside controller");
		MovieDto movieName = movieServiceimpl.getMovieName(name);

		return new ResponseEntity<MovieDto>(movieName, HttpStatus.FOUND);

	}

	@GetMapping("/getmovie")
	public ResponseEntity<List<MovieDto>> getMoviebyPrice(@RequestParam("price") int price) {
		System.out.println("Inside controller");
		System.out.println("Price : "+price);
		List<MovieDto> moviebyPrice = movieServiceimpl.getMoviebyPrice(price);
		
		return new ResponseEntity<List<MovieDto>>(moviebyPrice, HttpStatus.FOUND);

	}
	
	@DeleteMapping("/deletemovie")
	public ResponseEntity<MovieDto> deleteMoviebyname(@RequestParam String name){
		
		MovieDto deleteMovieByName = movieServiceimpl.deleteMovieByName(name);
		
		return new ResponseEntity<MovieDto>(deleteMovieByName, HttpStatus.GONE);
		
	}
	
	@PutMapping("/updateprice/{price}")
	public ResponseEntity<List<MovieDto>> updatePriceInMovie(@PathVariable int price, @RequestBody MovieDto moviedto ){
		
		List<MovieDto> updatePriceInMovie = movieServiceimpl.updatePriceInMovie(price,moviedto);
		return new ResponseEntity<List<MovieDto>>(updatePriceInMovie, HttpStatus.OK);
		
		
	}

}
