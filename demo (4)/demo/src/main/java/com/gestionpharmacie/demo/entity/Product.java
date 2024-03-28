package com.gestionpharmacie.demo.entity;

import com.gestionpharmacie.demo.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;

    private String name;
     private float  price;
     private Long quantity ;



   public ProductDto getProductDto() {
       ProductDto productDto = new ProductDto();
       productDto.setId(id);
       productDto.setName(name);
       productDto.setPrice(price);
       productDto.setQuantity(quantity);
    return productDto;
   }
}
