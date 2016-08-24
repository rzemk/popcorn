package com.chyld.repositories;

import com.chyld.entities.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IMovieRepository extends PagingAndSortingRepository<Movie, Integer>{
}
