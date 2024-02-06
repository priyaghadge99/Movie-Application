package com.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.Entity.MovieEntity;

@Repository
public interface MovieDao  extends JpaRepository<MovieEntity, Integer>{

	public MovieEntity findByName(String name);

	public List<MovieEntity> findByPrice(int price);
}
