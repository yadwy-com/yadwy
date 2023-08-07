package com.yadwy.yadwy.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String image;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;

    @NotNull
    private LocalDate createdAt;

    private LocalDate updatedAt;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<Review> reviews =  new ArrayList<>();
//
//    @ManyToOne
//    @JoinColumn(name = "vendor_id")
//    private User vendor;
//
//
//    @ManyToMany(mappedBy = "products")
//    private List<Order> orders = new ArrayList<>();
//
//
//    @ManyToMany(mappedBy = "products")
//    private List<Cart> carts = new ArrayList<>();

}