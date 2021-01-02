package com.kodilla.project.service;

import com.kodilla.project.domain.Offer;
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

    public List<Offer> getOffersByName(String name) {
        return offerDao.findByName(name);
    }

    public Optional<Offer> getOffer(final Long id) {
        return offerDao.findById(id);
    }

    public Offer saveOffer(final Offer offer) {
            return offerDao.save(new Offer.Builder()
            .id(offer.getId())
            .name(offer.getName())
            .description(offer.getDescription())
            .price(offer.getPrice())
            .build());
    }

    public void deleteOffer(final Long id) {
        offerDao.deleteById(id);
    }
}
