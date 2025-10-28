package com.example.ordermanagement.repository;

import com.example.ordermanagement.model.Order;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    private final Map<String, Order> orderMap = new HashMap<>();

    public Order save(Order order) {
        orderMap.put(order.getId(), order);
        return order;
    }

    public Optional<Order> findById(String id) {
        return Optional.ofNullable(orderMap.get(id));
    }

    public List<Order> findAll() {
        return new ArrayList<>(orderMap.values());
    }

    public void delete(String id) {
        orderMap.remove(id);
    }
}
