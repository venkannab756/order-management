package com.example.ordermanagement.service;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public Optional<Order> getOrder(String id) {
        return repository.findById(id);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public boolean cancelOrder(String id) {
        Optional<Order> optionalOrder = repository.findById(id);
        if (optionalOrder.isPresent() && optionalOrder.get().getStatus() == Order.Status.PENDING) {
            repository.delete(id);
            return true;
        }
        return false;
    }

    @Scheduled(fixedRate = 300000) // 5 minutes
    public void updatePendingOrders() {
        repository.findAll().forEach(order -> {
            if (order.getStatus() == Order.Status.PENDING) {
                order.setStatus(Order.Status.PROCESSING);
            }
        });
    }
}
