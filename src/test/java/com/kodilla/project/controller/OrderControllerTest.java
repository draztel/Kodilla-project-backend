package com.kodilla.project.controller;

import com.kodilla.project.domain.Offer;
import com.kodilla.project.domain.Order;
import com.kodilla.project.domain.User;
import com.kodilla.project.domain.dto.OrderDto;
import com.kodilla.project.domain.dto.UserDto;
import com.kodilla.project.mapper.OrderMapper;
import com.kodilla.project.service.OrderDbService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
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
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(OrderController.class)
@RunWith(SpringRunner.class)
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderDbService service;

    @MockBean
    private OrderMapper mapper;

    @Test
    public void shouldGetAllOrders() throws Exception {
        //given
        List<OrderDto> orderDtoList = new ArrayList<>();
        final OrderDto orderDto1 = new OrderDto();
        final OrderDto orderDto2 = new OrderDto();
        orderDtoList.add(orderDto1);
        orderDtoList.add(orderDto2);

        List<Order> orderList = new ArrayList<>();
        final Order order1 = new Order();
        final Order order2 = new Order();
        orderList.add(order1);
        orderList.add(order2);

        when(service.getOrders()).thenReturn(orderList);
        when(mapper.mapToOrderDtoList(orderList)).thenReturn(orderDtoList);

        //when & then
        mockMvc.perform(get("/v1/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }

    @Test
    public void shouldGetOrder() throws Exception {
        //given
        final User user = new User();
        final Offer offer = new Offer();
    }

}
