package com.yadwy.yadwy.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "yadwy_order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate createdAt;
    private double totalAmount;
    private String customerName;
    private String shippingAddress;
    private String contactNumber;
    private String email;

//    @ManyToMany
//    @JoinTable(
//            name = "order_product",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name="product_id")
//    )
//    private List<Product> products = new ArrayList<>();


}