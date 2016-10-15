/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monash.fit5042.govtservices;

import com.monash.fit5042.govtservice.entities.GovtService;
import com.monash.fit5042.govtservice.entities.ServiceType;
import java.util.List;

public interface GovernmentServiceListener {
    public GovtService getServiceById(String id);
    public void addService(GovtService service);
    public List<GovtService> getAllAvailableServices();
    public void editService(GovtService service);
    public void deleteService(String id);
    public List<GovtService> searchServices(String query);
    
    public ServiceType getServiceTypeById(String id);
    public void addServiceType(ServiceType serviceType);
    public List<ServiceType> getAllAvailableServicesType();
    public void editServiceType(ServiceType service);
    public void deleteServiceType(String id);
    
    
}
