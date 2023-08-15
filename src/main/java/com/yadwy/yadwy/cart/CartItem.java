package com.yadwy.yadwy.cart;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yadwy.yadwy.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "cart_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer quantity;

    private double discount;

    private double productPrice;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonBackReference
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        if (Double.compare(discount, cartItem.discount) != 0) return false;
        if (Double.compare(productPrice, cartItem.productPrice) != 0) return false;
        if (!Objects.equals(id, cartItem.id)) return false;
        if (!Objects.equals(quantity, cartItem.quantity)) return false;
        if (!Objects.equals(cart, cartItem.cart)) return false;
        return Objects.equals(product, cartItem.product);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (cart != null ? cart.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", productPrice=" + productPrice +
                ", cart=" + cart +
                ", product=" + product +
                '}';
    }
}
