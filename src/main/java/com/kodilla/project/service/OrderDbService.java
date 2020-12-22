package com.kodilla.project.service;

import com.kodilla.project.domain.Order;
import com.kodilla.project.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDbService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getOrders() {
        return orderDao.findAll();
    }

    public Optional<Order> getOrder(final Long id) {
        return orderDao.findById(id);
    }

    public Order saveOrder(final Order order) {
        return orderDao.save(order);
    }

    public void deleteOrder(final Long id) {
        orderDao.deleteById(id);
    }
}
