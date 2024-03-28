package com.gestionpharmacie.demo.services.Bill;

import com.gestionpharmacie.demo.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillService  {
    public void getBill(Long userId);
}
