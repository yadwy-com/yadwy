package com.yadwy.yadwy.review;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yadwy.yadwy.product.Product;
import com.yadwy.yadwy.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String comment;

    private Integer rating;

    private LocalDate createAt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private User customer;
}