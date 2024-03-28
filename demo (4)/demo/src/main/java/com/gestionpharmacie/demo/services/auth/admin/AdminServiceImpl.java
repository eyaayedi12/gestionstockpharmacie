package com.gestionpharmacie.demo.services.auth.admin;

import com.gestionpharmacie.demo.dto.ProductDto;
import com.gestionpharmacie.demo.entity.Product;
import com.gestionpharmacie.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl  implements AdminService {
    private final ProductRepository productRepository ;




    @Override
    public boolean addproduct(ProductDto productDto) throws IOException {
        try {
            // Vérifier si l'utilisateur existe déjà
            if (productRepository.existsProductByName(productDto.getName())) {
                // L'utilisateur existe déjà, ne rien faire et retourner false
                return false;
            }


            Product product = new Product();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setQuantity(productDto.getQuantity());
            productRepository.save(product);
            return true;
        }catch(Exception e) {
            return false;
        }



    }
    @Override
    public List<ProductDto> getAllProducts() {
        return  productRepository.findAll().stream().map(Product :: getProductDto).collect(Collectors.toList());
    }
    @Override
    public ProductDto getproductbyid(long id) {
        Optional<Product> optionalproduct;
        optionalproduct = productRepository.findById(id);


        return optionalproduct.map(Product :: getProductDto).orElse(null);
    }
    @Override
    public void Deleteproduct(long id) {

        productRepository.deleteById(id);
    }
    public boolean updateproduct(Long proId, ProductDto productDto) throws IOException {
        Optional<Product> optionalProduct = productRepository.findById(proId);
        if (optionalProduct.isPresent()) {
            Product pro = optionalProduct.get();
            pro.setName(productDto.getName());
            pro.setPrice(productDto.getPrice());
            pro.setQuantity(productDto.getQuantity());
            productRepository.save(pro);
            return true;

        } else {

            return false;
        }

    }}
