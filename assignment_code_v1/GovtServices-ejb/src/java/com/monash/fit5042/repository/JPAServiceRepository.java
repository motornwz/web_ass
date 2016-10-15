package com.monash.fit5042.repository;

import com.monash.fit5042.govtservice.entities.GovtService;
import com.monash.fit5042.govtservice.entities.GovtUser;
import com.monash.fit5042.govtservice.entities.ServiceType;
import com.monash.fit5042.govtservice.repository.GovtServiceRepository;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class JPAServiceRepository implements GovtServiceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addGovService(GovtService service) throws Exception {
        entityManager.persist(service);
    }

    @Override
    public GovtService searchServiceById(String id) throws Exception {
        GovtService service = entityManager.find(GovtService.class, Long.valueOf(id));
        return service;
    }

    @Override
    public List<GovtService> getAllServices() throws Exception {
        return entityManager.createNamedQuery(GovtService.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeService(String serviceId) throws Exception {

        GovtService service = this.searchServiceById(serviceId);
        if (service != null) {
            entityManager.remove(service);
        }
    }

    @Override
    public void editService(GovtService service) throws Exception {
        if(service!=null){
            entityManager.merge(service);
        }
    }

    @Override
    public Set<GovtService> searchServiceByContactPerson(GovtUser contactPerson) throws Exception {
        return null;
    }

    @Override
    public List<GovtService> queryServices(String query) throws Exception {
        
        //lower removes the case sensitive when searching for a service
        
        Query createQuery = entityManager.createQuery(
                "SELECT g FROM GovtService g WHERE LOWER(g.serviceName) LIKE :query OR g.id = :query1 "
                + "OR LOWER(g.serviceType) LIKE :query2");

        createQuery.setParameter("query", "%" + query.toLowerCase() + "%");

        Long id = getServiceIdIfExists(query);
        if (id != null) {
            createQuery.setParameter("query1", id);
        } else {
            //asuming that there's no id with -1
            createQuery.setParameter("query1", -1);
        }
        createQuery.setParameter("query2", "%" + query.toLowerCase() + "%");
        createQuery.setMaxResults(20);

        return createQuery.getResultList();
    }

    private Long getServiceIdIfExists(String query) {
        Long retVal = null;
        try {
            retVal = Long.valueOf(query);
        } catch (NumberFormatException e) {
            //ignore exception if it is not a id it will fail
        }
        return retVal;
    }

    //**
    //Functionality relating to users
    //**
    @Override
    public List<GovtUser> getAllGovtUsers() throws Exception {
        return entityManager.createNamedQuery(GovtUser.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void addUser(GovtUser user) throws Exception {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(String userId) throws Exception {
         GovtUser user = this.searchUserById(userId);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void editUser(GovtUser user) throws Exception {
         if(user!=null){
            entityManager.merge(user);
        }
    }

    @Override
    public GovtUser searchUserById(String id) throws Exception {
        GovtUser service = entityManager.find(GovtUser.class, Long.valueOf(id));
        return service;
    }
   
    /**
     * Functionality relating to Service Types
     */
    @Override
    public List<ServiceType> getAllServiceTypes() throws Exception {
       return entityManager.createNamedQuery(ServiceType.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void addServiceType(ServiceType user) throws Exception {
        if (user!=null){
            entityManager.persist(user);
        }
    }

    @Override
    public void removeServiceType(String serviceTypeId) throws Exception {
        ServiceType serviceType = this.searchForServiceTypeById(serviceTypeId);
        if (serviceType != null) {
            entityManager.remove(serviceType);
        }    
    }

    @Override
    public void editServiceType(ServiceType type) throws Exception {
        if(type!=null){
            entityManager.merge(type);
        }
    }

    @Override
    public ServiceType searchForServiceTypeById(String id) throws Exception {
        ServiceType service = entityManager.find(ServiceType.class, Long.valueOf(id));
        return service;    
    }
    
}
