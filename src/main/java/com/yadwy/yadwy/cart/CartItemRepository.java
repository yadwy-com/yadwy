package com.yadwy.yadwy.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
   List<CartItem> findByCartId(Long cartId);

   @Query("SELECT ci FROM CartItem ci WHERE ci.cart.id = ?1 AND ci.product.id = ?2")
   CartItem findCartItemByProductIdAndCartId(Long cartId, Long productId);
}
