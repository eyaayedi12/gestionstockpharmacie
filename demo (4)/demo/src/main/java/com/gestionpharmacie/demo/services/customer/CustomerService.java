package com.gestionpharmacie.demo.services.customer;

public interface CustomerService {
    public void addProductToCart(Long userId, Long productId);
    public void deleteProductFromCart(Long userId, Long productId);
}
