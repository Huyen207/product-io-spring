package com.huyenpt.productio.service;

import com.huyenpt.productio.entity.Order;
import com.huyenpt.productio.entity.OrderDetail;
import com.huyenpt.productio.entity.Product;
import com.huyenpt.productio.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    
    public List<OrderDetail> saveAll(List<OrderDetail> orderDetail) {
        return orderDetailRepository.saveAll(orderDetail);
    }
    public List<OrderDetail> SavaAllOrderDetailByProductIds(Order order, List<Product> productList) {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (Product product : productList) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(product);
            orderDetail.setOrder(order);
            orderDetailList.add(orderDetail);
        }
        this.saveAll(orderDetailList);
        return orderDetailList;
    }
}
