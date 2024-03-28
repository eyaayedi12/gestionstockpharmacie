package com.gestionpharmacie.demo.services.auth.users;

import com.gestionpharmacie.demo.dto.userDto;
import com.gestionpharmacie.demo.entity.User;

import java.util.List;

public interface UsersService {
    List<userDto> getCustomers();


}
