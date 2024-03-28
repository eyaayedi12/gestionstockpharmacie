package com.gestionpharmacie.demo.repository;
import com.gestionpharmacie.demo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<Cart,Long> {
    public Cart findCartByUserId(Long Id) ;

}
