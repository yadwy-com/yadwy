package com.yadwy.yadwy.review;

import com.yadwy.yadwy.product.Product;
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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //todo: relationship with user
    private String User;

    @NotNull
    private String comment;

    private Integer rating;

    private LocalDate createAt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
