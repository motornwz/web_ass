package com.monash.fit5042.govtservice.repository;

import com.monash.fit5042.govtservice.entities.GovtService;
import com.monash.fit5042.govtservice.entities.GovtUser;
import com.monash.fit5042.govtservice.entities.ServiceType;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

@Remote
public interface GovtServiceRepository {
        
    //Methods relating to services
    public void addGovService(GovtService service) throws Exception;
    public GovtService searchServiceById(String id) throws Exception;
    public List<GovtService> getAllServices() throws Exception;
    public List<GovtService> queryServices(String query) throws Exception;
    public void removeService(String serviceId) throws Exception;
    public void editService(GovtService property) throws Exception;
    Set<GovtService> searchServiceByContactPerson(GovtUser contactPerson) throws Exception;
    
    //Methods relating to services
    public List<GovtUser> getAllGovtUsers() throws Exception;
    public void addUser(GovtUser user) throws Exception;
    public void removeUser(String serviceId) throws Exception;
    public void editUser(GovtUser user) throws Exception;
    public GovtUser searchUserById(String id) throws Exception;
    
    //Methods relating to services
    public List<ServiceType> getAllServiceTypes() throws Exception;
    public void addServiceType(ServiceType user) throws Exception;
    public void removeServiceType(String serviceTypeId) throws Exception;
    public void editServiceType(ServiceType type) throws Exception;
    public ServiceType searchForServiceTypeById(String id) throws Exception;
       
}
