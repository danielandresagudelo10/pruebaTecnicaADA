package com.ada.pruebajunior.service;

import com.ada.pruebajunior.model.Company;
import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAllCompanies();
    Optional<Company> getCompanyById(Integer id);
    Company saveCompany(Company company);
    void deleteCompany(Integer id);
    Optional<Company> getCompanyByCodigo(String codigoCompany);
}