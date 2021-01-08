package com.kodilla.project.mapper;

import com.kodilla.project.domain.Game;
import com.kodilla.project.domain.Offer;
import com.kodilla.project.domain.dto.GameDto;
import com.kodilla.project.domain.dto.OfferDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class OfferMapperTest {

    @InjectMocks
    private OfferMapper mapper;

    @Test
    public void shouldMapToOffer() {
        //given
        OfferDto offerDto = new OfferDto(1l, "name", "description", 100.00);
        Long testId = offerDto.getId();

        //when
        Offer offer = mapper.mapToOffer(offerDto);

        //Then
        Assert.assertEquals(testId, offer.getId());
        Assert.assertEquals("name", offer.getName());
        Assert.assertEquals("description", offer.getDescription());
        Assert.assertEquals(100.00, offer.getPrice(), 0.01);
    }

    @Test
    public void shouldMapToOfferDto() {
        //given
        Offer offer = new Offer(1l, "name", "description", 100.00);
        Long testId = offer.getId();

        //when
        OfferDto offerDto = mapper.mapToOfferDto(offer);

        //Then
        Assert.assertEquals(testId, offerDto.getId());
        Assert.assertEquals("name", offerDto.getName());
        Assert.assertEquals("description", offerDto.getDescription());
        Assert.assertEquals(100.00, offerDto.getPrice(), 0.01);
    }

    @Test
    public void shouldMapToOfferList() {
        //given
        List<OfferDto> offerDtoList = new ArrayList<>();
        offerDtoList.add(new OfferDto(1l, "name", "description", 100.00));
        offerDtoList.add(new OfferDto(1l, "name", "description", 100.00));

        //when
        List<Offer> offerList = mapper.mapToOfferList(offerDtoList);

        //then
        Assert.assertEquals(2, offerList.size());
    }

    @Test
    public void shouldMapToOfferDtoList() {
        //given
        List<Offer> offerList = new ArrayList<>();
        offerList.add(new Offer(1l, "name", "description", 100.00));
        offerList.add(new Offer(1l, "name", "description", 100.00));

        //when
        List<OfferDto> offerDtoList = mapper.mapToOfferDtoList(offerList);

        //then
        Assert.assertEquals(2, offerList.size());
    }
}
