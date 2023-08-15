package com.yadwy.yadwy.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yadwy.yadwy.address.Address;
import com.yadwy.yadwy.cart.Cart;
import com.yadwy.yadwy.product.Product;
import com.yadwy.yadwy.review.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Review> reviews = new ArrayList<>();

    @OneToOne(mappedBy = "customer")
    @JsonBackReference
    private Cart cart;

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}