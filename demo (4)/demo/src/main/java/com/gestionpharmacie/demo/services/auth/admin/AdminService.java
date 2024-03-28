package com.gestionpharmacie.demo.services.auth.admin;

import com.gestionpharmacie.demo.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {
    boolean addproduct(ProductDto productDto) throws IOException;
    public List<ProductDto> getAllProducts();
    public ProductDto getproductbyid(long id);
    public void Deleteproduct(long id);
    public boolean updateproduct(Long proId, ProductDto productDto)throws IOException;
}
