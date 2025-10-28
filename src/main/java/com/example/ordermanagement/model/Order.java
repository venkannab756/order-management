package com.example.ordermanagement.model;

import java.util.List;

public class Order {

    public enum Status { PENDING, PROCESSING, SHIPPED, DELIVERED }

    private String id;
    private List<String> items;
    private Status status;

    public Order() {}

    public Order(String id, List<String> items) {
        this.id = id;
        this.items = items;
        this.status = Status.PENDING;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public List<String> getItems() { return items; }
    public void setItems(List<String> items) { this.items = items; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}