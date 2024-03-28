package com.gestionpharmacie.demo.controller;

import com.gestionpharmacie.demo.services.Bill.BillService;
import com.gestionpharmacie.demo.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private final CustomerService customerService ;
    private final BillService billService ;

    @PostMapping("/add")
    public ResponseEntity<String> addProductToCart(@RequestParam Long userId, @RequestParam Long productId) {
        try {
            customerService.addProductToCart(userId, productId);
            return ResponseEntity.ok("Product added to cart ");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding product to cart: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProductFromCart(@RequestParam Long userId, @RequestParam Long productId) {
        try {
            customerService.deleteProductFromCart(userId, productId);
            return ResponseEntity.ok("Product deleted from cart");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product or cart not found: " + e.getMessage());
        }
    }
    @PostMapping("/generatebill")
    public ResponseEntity<String> generateBill(@RequestParam Long userId) {
        try {
            billService.getBill(userId);
            return ResponseEntity.ok("Bill generated successfully for user with ID: " + userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating bill: " + e.getMessage());
        }
    }
}

