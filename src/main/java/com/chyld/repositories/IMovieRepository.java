package com.chyld.repositories;

import com.chyld.entities.Movie;
import com.chyld.enums.Rating;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IMovieRepository extends PagingAndSortingRepository<Movie, Integer>{
    Movie findByName(String name);
    List<Movie> findByRatingOrderByReleasedDesc(Rating rating);
}
