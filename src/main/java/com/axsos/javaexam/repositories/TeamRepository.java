package com.axsos.javaexam.repositories;

import com.axsos.javaexam.models.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Long> {
    List<Team> findAll();
    Optional<Team> findById(Long id);

}
