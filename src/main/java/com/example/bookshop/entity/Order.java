package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    private String buildingAddress;

    private String shippingAddress;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private double totalAmount;

    public Order(LocalDate orderDate, String buildingAddress, String shippingAddress, PaymentMethod paymentMethod, double totalAmount) {
        this.orderDate = orderDate;
        this.buildingAddress = buildingAddress;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
    }

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();


    @ManyToOne
    private Customer customer;

    public void addOrderItem(OrderItem orderItem){
        orderItem.setOrder(this);
        orderItems.add(orderItem);
    }
}
