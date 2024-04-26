package com.huyenpt.productio.service;

import com.huyenpt.productio.entity.Order;
import com.huyenpt.productio.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public Order save(Order order) {
        return orderRepository.save(order);
    }
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    public List<Order> findAll() {
        return orderRepository.findAllWithOrderDetailsAndProducts();
    }
    public List<Order> getOrderDetailsWithProductAndOrderInfo(Long id, String clientName) {
        return orderRepository.findByIdOrClientNameContaining(id, clientName);
    }
}
