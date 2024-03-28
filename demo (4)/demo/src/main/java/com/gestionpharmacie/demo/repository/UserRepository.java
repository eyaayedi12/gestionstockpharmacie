package com.gestionpharmacie.demo.repository;

import com.gestionpharmacie.demo.entity.User;

import com.gestionpharmacie.demo.enums.userRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {



    Optional<User> findFirstByEmail(String email);

    User findByUserRole(userRole userRole);

    boolean existsByEmail(String email);

    Optional<User> findById(Long id);
}
