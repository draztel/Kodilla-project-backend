package com.kodilla.project.controller;

import com.kodilla.project.domain.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders/{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) {
        return new OrderDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orders")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orders", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {

    }
}
