package com.kodilla.project.mapper;

import com.kodilla.project.domain.Offer;
import com.kodilla.project.domain.dto.OfferDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OfferMapper {

    public Offer mapToOffer(final OfferDto offerDto) {
        return new Offer(
                offerDto.getId(),
                offerDto.getName(),
                offerDto.getDescription(),
                offerDto.getPrice()
        );
    }

    public OfferDto mapToOfferDto(final Offer offer) {
        return new OfferDto(
                offer.getId(),
                offer.getName(),
                offer.getDescription(),
                offer.getPrice()
        );
    }

    public List<OfferDto> mapToOfferDtoList(final List<Offer> offerList) {
        return offerList.stream()
                .map(this::mapToOfferDto)
                .collect(Collectors.toList());
    }

    public List<Offer> mapToOfferList(final List<OfferDto> offerDtoList) {
        return offerDtoList.stream()
                .map(this::mapToOffer)
                .collect(Collectors.toList());
    }
}
