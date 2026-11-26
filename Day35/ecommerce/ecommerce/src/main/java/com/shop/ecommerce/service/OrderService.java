package com.shop.ecommerce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shop.ecommerce.dto.OrderItemRequest;
import com.shop.ecommerce.dto.OrderRequest;
import com.shop.ecommerce.exception.ResourceNotFoundException;
import com.shop.ecommerce.model.*;
import com.shop.ecommerce.repository.*;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Order placeOrder(String email, OrderRequest request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + email));

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");

        BigDecimal total = BigDecimal.ZERO;

        for (OrderItemRequest line : request.items()) {
            Product product = productRepository.findById(line.productId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + line.productId()));

            if (product.getStock() < line.quantity()) {
                throw new IllegalArgumentException("Not enough stock for " + product.getName() + " (available: " + product.getStock() + ")");
            }

            // Deduct stock and save product
            product.setStock(product.getStock() - line.quantity());
            productRepository.save(product);

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(line.quantity());
            item.setUnitPrice(product.getPrice());
            order.addItem(item);

            total = total.add(product.getPrice().multiply(BigDecimal.valueOf(line.quantity())));
        }

        order.setTotalAmount(total);
        return orderRepository.save(order);
    }

    public List<Order> getOrdersForUser(String email) {
        return orderRepository.findByUserEmailOrderByOrderDateDesc(email);
    }
}