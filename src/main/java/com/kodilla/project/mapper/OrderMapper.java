package com.kodilla.project.mapper;

import com.kodilla.project.domain.Order;
import com.kodilla.project.domain.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getUser(),
                orderDto.getOffer()
        );
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser(),
                order.getOffer()
        );
    }

    public List<Order> mapToOrderList(final List<OrderDto> orderDtoList) {
        return orderDtoList.stream()
                .map(this::mapToOrder)
                .collect(Collectors.toList());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
