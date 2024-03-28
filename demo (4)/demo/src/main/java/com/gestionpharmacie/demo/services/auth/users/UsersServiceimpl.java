package com.gestionpharmacie.demo.services.auth.users;

import com.gestionpharmacie.demo.dto.userDto;
import com.gestionpharmacie.demo.entity.User;
import com.gestionpharmacie.demo.enums.userRole;
import com.gestionpharmacie.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceimpl implements UsersService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<userDto> getCustomers() {
        return (List<userDto>) userRepository.findByUserRole(userRole.Customer);
    }


}



