package com.kodilla.project.service;

import com.kodilla.project.domain.Offer;
import com.kodilla.project.exception.AlreadyExistsException;
import com.kodilla.project.repository.OfferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferDbService {

    @Autowired
    private OfferDao offerDao;

    public List<Offer> getOffers() {
        return offerDao.findAll();
    }

    public Optional<Offer> getOffer(final Long id) {
        return offerDao.findById(id);
    }

    public Offer saveOffer(final Offer offer) {
            return offerDao.save(offer);
    }

    public void deleteOffer(final Long id) {
        offerDao.deleteById(id);
    }
}
