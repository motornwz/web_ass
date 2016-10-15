/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monash.fit5042.govtservice.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "service_type")
@NamedQueries({
    @NamedQuery(name = ServiceType.GET_ALL_QUERY_NAME, query = "SELECT g FROM ServiceType g")})
public class ServiceType implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "ServiceType.getAll";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String title;
    private String description;
    
    @ElementCollection(fetch=EAGER)
    @OneToMany
    @JoinColumn
    protected Set<GovtService> services = new HashSet();

    public ServiceType() {      
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    public Set<GovtService> getServices() {
        return services;
    }

    public void setServices(Set<GovtService> services) {
        this.services = services;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return title;
    }
    
}
