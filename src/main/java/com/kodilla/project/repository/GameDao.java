package com.kodilla.project.repository;

import com.kodilla.project.domain.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface GameDao extends CrudRepository<Game, Long> {

    @Override
    List<Game> findAll();

    @Override
    Optional<Game> findById(Long id);

    List<Game> findByName(String name);
}
