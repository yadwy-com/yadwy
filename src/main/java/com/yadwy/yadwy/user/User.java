package com.yadwy.yadwy.user;

import com.yadwy.yadwy.address.Address;
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

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();


//
//    @OneToMany(mappedBy = "yadwy_user", cascade = CascadeType.ALL)
//    private List<Product> products = new ArrayList<>();


    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}