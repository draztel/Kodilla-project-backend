package com.kodilla.project.repository;

import com.kodilla.project.domain.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OfferDao extends CrudRepository<Offer, Long> {

    @Override
    List<Offer> findAll();

    @Override
    Optional<Offer> findById(Long id);
}
