package com.ada.pruebajunior.controller;

import com.ada.pruebajunior.model.Company;
import com.ada.pruebajunior.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Company> getCompanyById(@PathVariable Integer id) {
        return companyRepository.findById(id);
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @GetMapping("/by-codigo/{codigo}")
    public CompanyDetailsDTO getCompanyByCodigo(@PathVariable String codigo) {
        Optional<Company> company = companyRepository.findByCodigoCompany(codigo);
        
        CompanyDetailsDTO dto = new CompanyDetailsDTO();
        dto.setCodigoCompany(company.get().getCodigoCompany());
        dto.setNameCompany(company.get().getNameCompany());
        dto.setAppName("Sistema ERP");
        dto.setVersion("1.0");
        
        return dto;
    }

    public static class CompanyDetailsDTO {
        private String codigoCompany;
        private String nameCompany;
        private String appName;
        private String version;
        
        // Getters y Setters
        public String getCodigoCompany() { return codigoCompany; }
        public void setCodigoCompany(String codigoCompany) { this.codigoCompany = codigoCompany; }
        public String getNameCompany() { return nameCompany; }
        public void setNameCompany(String nameCompany) { this.nameCompany = nameCompany; }
        public String getAppName() { return appName; }
        public void setAppName(String appName) { this.appName = appName; }
        public String getVersion() { return version; }
        public void setVersion(String version) { this.version = version; }
    }
}