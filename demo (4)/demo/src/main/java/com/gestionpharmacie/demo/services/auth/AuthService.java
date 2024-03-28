package com.gestionpharmacie.demo.services.auth;

import com.gestionpharmacie.demo.dto.SignUpRequest;
import com.gestionpharmacie.demo.dto.userDto;

public interface AuthService {

    public userDto createCustomer(SignUpRequest SignUpRequest);
    public boolean hasCustomerWithEmail(String email);
}
