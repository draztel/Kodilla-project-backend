package com.kodilla.project.controller;

import com.kodilla.project.domain.Offer;
import com.kodilla.project.domain.dto.OfferDto;
import com.kodilla.project.mapper.OfferMapper;
import com.kodilla.project.service.OfferDbService;
import org.hamcrest.Matchers;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.Invocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(OfferController.class)
@RunWith(SpringRunner.class)
public class OfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OfferDbService service;

    @MockBean
    private OfferMapper mapper;

    @Test
    public void shouldGetAllOffers() throws Exception {
        //Given
        List<OfferDto> offerDtoList = new ArrayList<>();
        final OfferDto offerDto1 = new OfferDto(1l, "name", "description", 100.00);
        final OfferDto offerDto2 = new OfferDto(1l, "name", "description", 100.00);
        offerDtoList.add(offerDto1);
        offerDtoList.add(offerDto2);

        List<Offer> offerList = new ArrayList<>();
        final Offer offer1 = new Offer(1l, "name", "description", 100.00);
        final Offer offer2 = new Offer(1l, "name", "description", 100.00);
        offerList.add(offer1);
        offerList.add(offer2);

        when(service.getOffers()).thenReturn(offerList);
        when(mapper.mapToOfferDtoList(offerList)).thenReturn(offerDtoList);

        //when & then
        mockMvc.perform(get("/v1/offers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }

    @Test
    public void shouldGetOffer() throws Exception {
        //given
        final OfferDto offerDto = new OfferDto(1l, "name", "description", 100.00);
        final Offer offer = new Offer(1l, "name", "description", 100.00);

        when(service.getOffer(anyLong())).thenReturn(Optional.of(offer));
        when(mapper.mapToOfferDto(offer)).thenReturn(offerDto);

        //when & then
        mockMvc.perform(get("/v1/offers/1")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("name")))
                .andExpect(jsonPath("$.description", is("description")))
                .andExpect(jsonPath("$.price", is(100.00)));
    }

    @Test
    public void shouldDeleteOffer() throws Exception {
        //given
        //when & then
        mockMvc.perform(delete("/v1/offers/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateOffer() throws Exception {
        //given
        Offer offer = new Offer(1l, "name", "description", 100.00);
        OfferDto offerDto = new OfferDto(1l, "name", "description", 100.00);

        when(mapper.mapToOffer(offerDto)).thenReturn(offer);
        when(service.saveOffer(offer)).thenReturn(offer);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(offerDto);

        //then & when
        mockMvc.perform(post("/v1/offers")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateOffer() throws Exception {
        //given
        Offer offer = new Offer(1l, "name", "description", 100.00);
        OfferDto offerDto = new OfferDto(1l, "name", "description", 100.00);

        when(mapper.mapToOffer(offerDto)).thenReturn(offer);
        when(service.saveOffer(offer)).thenReturn(offer);
        when(mapper.mapToOfferDto(offer)).thenReturn(offerDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(offerDto);

        //then & when
        mockMvc.perform(put("/v1/offers")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(jsonContent))
                .andExpect(status().isOk());
    }
}
