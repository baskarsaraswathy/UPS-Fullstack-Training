package com.shop.ecommerce.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.shop.ecommerce.dto.OrderRequest;
import com.shop.ecommerce.model.Order;
import com.shop.ecommerce.service.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Object> placeOrder(Authentication authentication, @Valid @RequestBody OrderRequest request) {
        Order order = orderService.placeOrder(authentication.getName(), request);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping("/my")
    public List<Order> myOrders(Authentication authentication) {
        return orderService.getOrdersForUser(authentication.getName());
    }
}
