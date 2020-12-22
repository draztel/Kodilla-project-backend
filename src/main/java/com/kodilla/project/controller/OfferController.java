package com.kodilla.project.controller;

import com.kodilla.project.domain.dto.OfferDto;
import com.kodilla.project.exception.AlreadyExistsException;
import com.kodilla.project.exception.NotFoundException;
import com.kodilla.project.mapper.OfferMapper;
import com.kodilla.project.service.OfferDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class OfferController {
    @Autowired
    private OfferDbService offerDbService;

    @Autowired
    private OfferMapper offerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/offers")
    public List<OfferDto> getOffers() {
        return offerMapper.mapToOfferDtoList(offerDbService.getOffers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/offers/{offerId}")
    public OfferDto getOffer(@PathVariable Long offerId) throws NotFoundException {
        return offerMapper.mapToOfferDto(offerDbService.getOffer(offerId).orElseThrow(NotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/offers/{offerId}")
    public void deleteOffer(@PathVariable Long offerId) {
        offerDbService.deleteOffer(offerId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/offers")
    public OfferDto updateOffer(@RequestBody OfferDto offerDto) {
        return offerMapper.mapToOfferDto(offerDbService.saveOffer(offerMapper.mapToOffer(offerDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/offers", consumes = APPLICATION_JSON_VALUE)
    public void createOffer(@RequestBody OfferDto offerDto) {
        offerDbService.saveOffer(offerMapper.mapToOffer(offerDto));
    }
}
