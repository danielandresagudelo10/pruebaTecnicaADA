package com.ada.pruebajunior.model;

import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "id_company")
    private Integer idCompany;
    
    @Column(name = "codigo_company", unique = true, nullable = false)
    private String codigoCompany;
    
    @Column(name = "name_company", nullable = false)
    private String nameCompany;
    
    @Column(name = "description_company")
    private String descriptionCompany;

    // Getters y Setters
    public Integer getIdCompany() { return idCompany; }
    public void setIdCompany(Integer idCompany) { this.idCompany = idCompany; }
    public String getCodigoCompany() { return codigoCompany; }
    public void setCodigoCompany(String codigoCompany) { this.codigoCompany = codigoCompany; }
    public String getNameCompany() { return nameCompany; }
    public void setNameCompany(String nameCompany) { this.nameCompany = nameCompany; }
    public String getDescriptionCompany() { return descriptionCompany; }
    public void setDescriptionCompany(String descriptionCompany) { this.descriptionCompany = descriptionCompany; }
}