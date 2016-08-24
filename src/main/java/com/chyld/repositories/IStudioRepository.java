package com.chyld.repositories;

import com.chyld.entities.Actor;
import com.chyld.entities.Movie;
import com.chyld.entities.Studio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IStudioRepository extends PagingAndSortingRepository<Studio, Integer>{
    @Query("select m from Movie m join m.studio s where s.id = :id")
    public Page<Movie> findAllMoviesByStudioId(@Param("id") int id, Pageable pagable);

    @Query("select distinct a from Movie m join m.studio s join m.actors a where s.id = :id")
    public Page<Actor> findAllActorsByStudioId(@Param("id") int id, Pageable pagable);
}
