package com.huyenpt.productio.repository;

import com.huyenpt.productio.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByIdOrClientNameContaining(Long id, String clientName);

    @Query("SELECT o FROM Order o JOIN FETCH o.orderDetails od JOIN FETCH od.product")
    List<Order> findAllWithOrderDetailsAndProducts();

}
