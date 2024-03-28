package com.gestionpharmacie.demo.controller;

import com.gestionpharmacie.demo.dto.ProductDto;
import com.gestionpharmacie.demo.services.auth.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    private final AdminService adminService;
    @PostMapping("/addproduct")
    public ResponseEntity<?> addproduct(@ModelAttribute ProductDto productDto) throws IOException {
        boolean done= adminService.addproduct(productDto);
        if(done) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @GetMapping("/allproducts")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(adminService.getAllProducts());
    }
    @DeleteMapping("/product/{id}")
    public  ResponseEntity<Void> Deleteproduct(@PathVariable  Long id) {
        adminService.Deleteproduct(id);
        return ResponseEntity.ok(null);

    }
    @PutMapping("/updateproduct/{proid}")
    public ResponseEntity<Void> updateproduct(@PathVariable Long proid,
                                                   @ModelAttribute ProductDto productDtoDto) throws IOException {
        if (adminService.updateproduct(proid, productDtoDto)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }
    }




