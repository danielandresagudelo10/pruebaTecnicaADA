package com.ada.pruebajunior.service;

import com.ada.pruebajunior.model.Company;
import com.ada.pruebajunior.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    
    private final CompanyRepository companyRepository;
    
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    
    @Override
    public Optional<Company> getCompanyById(Integer id) {
        return companyRepository.findById(id);
    }
    
    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }
    
    @Override
    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }
    
    @Override
    public Optional<Company> getCompanyByCodigo(String codigoCompany) {
        return companyRepository.findByCodigoCompany(codigoCompany);
    }
}