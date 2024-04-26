package com.huyenpt.productio.repository;

import com.huyenpt.productio.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingOrDescriptionContaining(String name, String description);
    
    @Query("SELECT p FROM Product p WHERE EXISTS (SELECT NULL FROM OrderDetail od WHERE od.productId = p.id AND od.orderId = ?1)")
    List<Product> findByOrderId(Long orderId);
}
