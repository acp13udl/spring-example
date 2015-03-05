package com.udl.softarch.springexample.repositories;

import com.udl.softarch.springexample.models.Greeting;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by david on 02/03/15.
 */
public interface GreetingRepository extends PagingAndSortingRepository<Greeting, Long> {
    List<Greeting> findByContentContaining(@Param("content") String content);
}
