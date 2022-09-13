package com.advanced.message.training.kafka.application;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }


}
