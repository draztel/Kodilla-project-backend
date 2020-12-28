package com.kodilla.project.controller;

import com.kodilla.project.domain.dto.OrderDto;
import com.kodilla.project.exception.NotFoundException;
import com.kodilla.project.mapper.OrderMapper;
import com.kodilla.project.service.OrderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDbService service;

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(service.getOrders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders/{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) throws NotFoundException {
        return orderMapper.mapToOrderDto(service.getOrder(orderId).orElseThrow(NotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        service.deleteOrder(orderId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orders")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return orderMapper.mapToOrderDto(service.saveOrder(orderMapper.mapToOrder(orderDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orders", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
        service.saveOrder(orderMapper.mapToOrder(orderDto));
    }
}
