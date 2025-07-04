package com.maron.restaurantapi.controller;

import com.maron.restaurantapi.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final List<Order> orders = new ArrayList<>();
    private long nextId = 1;

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        order.setId(nextId++);
        orders.add(order);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orders;
    }
}
