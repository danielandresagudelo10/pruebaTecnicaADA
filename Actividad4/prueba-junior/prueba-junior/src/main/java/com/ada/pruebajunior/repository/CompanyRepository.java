package com.ada.pruebajunior.repository;

import com.ada.pruebajunior.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByCodigoCompany(String codigoCompany);
}