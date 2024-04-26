package com.huyenpt.productio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "client_name", columnDefinition = "Varchar(100)")
    private String clientName;
    @Column(nullable = false, name = "address", columnDefinition = "Varchar(100)")
    private String address;
    @Column(nullable = false, name = "email", columnDefinition = "Varchar(100)")
    private String email;
    @Column(nullable = false, name = "phone", columnDefinition = "Varchar(100)")
    private String phone;
    @Column(nullable = false, name = "status", columnDefinition = "Varchar(100)")
    private String status;
    @Column(nullable = false, name = "price", columnDefinition = "Decimal")
    private Double price;
    @Column(nullable = false, name = "create_date", columnDefinition = "Varchar(100)")
    private LocalDate create_date;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;
}
