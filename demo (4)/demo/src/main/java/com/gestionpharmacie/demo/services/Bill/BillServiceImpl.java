package com.gestionpharmacie.demo.services.Bill;

import com.gestionpharmacie.demo.entity.Bill;
import com.gestionpharmacie.demo.entity.Cart;
import com.gestionpharmacie.demo.entity.Product;
import com.gestionpharmacie.demo.entity.User;
import com.gestionpharmacie.demo.repository.BillRepository;
import com.gestionpharmacie.demo.repository.CartRepository;
import com.gestionpharmacie.demo.repository.ProductRepository;
import com.gestionpharmacie.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService{
    private UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final BillRepository billRepository ;
    @Override
    public void getBill(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        Cart cart = cartRepository.findCartByUserId(userId);
        if (cart == null) {
            throw new IllegalStateException("Cart not found for user with id: " + userId);
        }
        float somme=0;
        // Récupération de la liste des produits dans le panier
        List<Product> productsCart = cart.getProducts();
        for (Product product : productsCart){

           somme=somme+product.getPrice();

        }
        Bill bill =new Bill();
        bill.setValue(somme);
        bill.setUser(userRepository.findById(userId).get());
        LocalDate localDate = LocalDate.now();
        bill.setDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        billRepository.save(bill);




    }



}
