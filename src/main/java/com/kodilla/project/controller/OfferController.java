package com.kodilla.project.controller;

import com.kodilla.project.domain.dto.OfferDto;
import com.kodilla.project.exception.OfferNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class OfferController {

    @RequestMapping(method = RequestMethod.GET, value = "/offers")
    public List<OfferDto> getOffers() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/offers/{offerId}")
    public OfferDto getOffer(@PathVariable Long offerId) throws OfferNotFoundException {
        return new OfferDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/offers/{offerId}")
    public void deleteOffer(@PathVariable Long offerId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/offers")
    public OfferDto updateOffer(@RequestBody OfferDto offerDto) {
        return new OfferDto();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/offers", consumes = APPLICATION_JSON_VALUE)
    public void createOffer(@RequestBody OfferDto offerDto) {

    }
}
