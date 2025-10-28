package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.service.OrderService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable String id) {
        return service.getOrder(id);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable String id) {
        boolean cancelled = service.cancelOrder(id);
        return cancelled ? "Order cancelled" : "Cannot cancel order";
    }
}
