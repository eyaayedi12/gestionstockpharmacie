package com.gestionpharmacie.demo.services.auth;


import com.gestionpharmacie.demo.dto.SignUpRequest;
import com.gestionpharmacie.demo.dto.userDto;

import com.gestionpharmacie.demo.enums.userRole;
import com.gestionpharmacie.demo.repository.UserRepository;
import com.gestionpharmacie.demo.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service

public class AuthServiceimpl implements AuthService{

    private final UserRepository userRepository ;


    public AuthServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //appeler la methode des qu l'application starts
    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRepository.findByUserRole(userRole.Admin);
        if(adminAccount== null)
        {
            User newAdminAccount =new User();
            newAdminAccount.setName("Admin");
            newAdminAccount.setEmail("admin@test.com");
            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
            newAdminAccount.setUserRole(userRole.Admin);
            userRepository.save(newAdminAccount);
            System.out.println("Admin account created ");

        }
    }
    @Override
    public userDto createCustomer(SignUpRequest SignUpRequest) {
        User User=new User();
        User.setName(SignUpRequest.getName());
        User.setEmail(SignUpRequest.getEmail());
        User.setPassword(new BCryptPasswordEncoder().encode(SignUpRequest.getPassword()));
        User.setUserRole(userRole.Customer);
        User createdUser=userRepository.save( User);
        userDto userDto=new userDto();
        userDto.setId(createdUser.getId());
        return userDto;

    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();

    }
}
