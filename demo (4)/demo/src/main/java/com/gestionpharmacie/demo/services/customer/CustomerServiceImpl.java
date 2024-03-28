package com.gestionpharmacie.demo.services.customer;

import com.gestionpharmacie.demo.entity.Cart;
import com.gestionpharmacie.demo.entity.Product;
import com.gestionpharmacie.demo.entity.User;
import com.gestionpharmacie.demo.repository.CartRepository;
import com.gestionpharmacie.demo.repository.ProductRepository;
import com.gestionpharmacie.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Override
    public void addProductToCart(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + productId));


        Cart cart = cartRepository.findCartByUserId(userId);
        if (cart == null) {
            
            cart = new Cart();
            cart.setUser(user);
        }


        List<Product> products = cart.getProducts();


        Optional<Product> cartProductOptional = products.stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst();

        if (cartProductOptional.isPresent()) {
            Product cartProduct = cartProductOptional.get();
            cartProduct.setQuantity(cartProduct.getQuantity() -1);
            product.setQuantity(product.getQuantity()+1);
            System.out.println(product.getQuantity());
            product.setQuantity(product.getQuantity()+1);
            System.out.println(product.getQuantity());
        } else {

            product.setQuantity(1L);
            products.add(product);
        }


        cart.setProducts(products);

        cartRepository.save(cart);
    }
    @Override
    public void deleteProductFromCart(Long userId, Long productId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        Cart cart = cartRepository.findCartByUserId(userId);
        if (cart == null) {
            throw new RuntimeException("Cart not found for user with id: " + userId);
        }
        List<Product> products = cart.getProducts();
        Optional<Product> productOptional = products.stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst();
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            Long quantity = product.getQuantity();


            if (quantity > 1) {
                product.setQuantity(quantity - 1);

                System.out.println(product.getQuantity());
                productRepository.findById(productId).get().setQuantity( productRepository.findById(productId).get().getQuantity()+1);
            } else {
                products.remove(product);
                productRepository.findById(productId).get().setQuantity( productRepository.findById(productId).get().getQuantity()+1);
            }
            cart.setProducts(products);
            cartRepository.save(cart);
        } else {
            throw new NoSuchElementException("Product not found in cart with id: " + productId);
        }
    }

}

