package com.yadwy.yadwy.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yadwy.yadwy.category.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String name;


    private String description;

    private String image;


    private Double price;


    private Integer quantity;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!Objects.equals(id, product.id)) return false;
        if (!Objects.equals(name, product.name)) return false;
        if (!Objects.equals(description, product.description)) return false;
        if (!Objects.equals(image, product.image)) return false;
        if (!Objects.equals(price, product.price)) return false;
        if (!Objects.equals(quantity, product.quantity)) return false;
        if (!Objects.equals(createdAt, product.createdAt)) return false;
        if (!Objects.equals(updatedAt, product.updatedAt)) return false;
        return Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", category=" + category +
                '}';
    }
}