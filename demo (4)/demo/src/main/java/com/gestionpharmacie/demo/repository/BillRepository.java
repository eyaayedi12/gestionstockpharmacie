package com.gestionpharmacie.demo.repository;

import com.gestionpharmacie.demo.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {

}
