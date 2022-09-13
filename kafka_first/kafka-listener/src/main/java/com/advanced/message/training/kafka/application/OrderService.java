package com.advanced.message.training.kafka.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final Map<Integer, String> products =  Map.of(1, "First product", 2, "Second product");
    private final ConcurrentHashMap<Integer, Order> orderStorage = new ConcurrentHashMap<>();
    private final int MAX_AVAILABLE_ORDER_AMOUNT = 1000;

    public void process(Order order) {
        if(!products.containsKey(order.getProductId())) {
            throw new ProductNotAvailableException("Product with number [{}] not available at that moment, try later");
        }
        if (order.getAmount() > MAX_AVAILABLE_ORDER_AMOUNT) {
            throw new ProductAmountExceededException("Order exceeded maximum amount");
        }
        orderStorage.put(order.getOrderId(), order);
    }

    public Order getOrderById(Integer orderId) {
        return orderStorage.get(orderId);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orderStorage.values());
    }
}
