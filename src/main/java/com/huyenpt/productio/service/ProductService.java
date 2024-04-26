package com.huyenpt.productio.service;

import com.huyenpt.productio.entity.Product;
import com.huyenpt.productio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    
    
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
    public List<Product> findByOrderId(Long orderId) {
        return productRepository.findByOrderId(orderId);
    }
    public List<Product> getProductsByOrderId(Long orderId) {
        return productRepository.findByOrderId(orderId);
    }
    public List<Product> findAllByIds(List<Long> ids) {
        return productRepository.findAllById(ids);
    }
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
    public List<Product> findByNameContainingOrDescriptionContaining(String name, String description) {
        return productRepository.findByNameContainingOrDescriptionContaining(name, description);
    }
}
