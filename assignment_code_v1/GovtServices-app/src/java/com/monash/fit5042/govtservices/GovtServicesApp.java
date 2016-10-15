/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monash.fit5042.govtservices;

import com.monash.fit5042.govtservice.entities.GovtService;
import com.monash.fit5042.govtservice.entities.GovtUser;
import com.monash.fit5042.govtservice.entities.ServiceType;
import com.monash.fit5042.govtservice.entities.UserType;
import com.monash.fit5042.govtservice.repository.GovtServiceRepository;
import com.monash.fit5042.govtservices.ui.GovernmentServicesGUIForm;
import com.monash.fit5042.govtservices.ui.GuiEventListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 *
 * @author Naveed Zanoon
 */
public class GovtServicesApp implements GovernmentServiceListener, 
        UserServiceListener{

    @EJB
    private static GovtServiceRepository govtRepository;
    
    private GuiEventListener listener;
    
    public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GovtServicesApp servicesApp = new GovtServicesApp();
                GovernmentServicesGUIForm govtForm 
                        = new GovernmentServicesGUIForm(servicesApp, servicesApp);
                //adds a callback listner to the gui
                servicesApp.listener = govtForm;
                govtForm.setVisible(true);
                
            }
        });
    }

    @Override
    public void addService(GovtService service) {
        try {
            govtRepository.addGovService(service);
            listener.reloadServiceTable();
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<GovtService> getAllAvailableServices() {
        List<GovtService> allGovtUsers = null;
        try {
            allGovtUsers = govtRepository.getAllServices();
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allGovtUsers;
    }

    @Override
    public void editService(GovtService service) {
         try {
            govtRepository.editService(service);
            listener.reloadServiceTable();
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteService(String id) {
        try {
            govtRepository.removeService(id);
            
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public GovtService getServiceById(String id) {
         GovtService service = null;
         try {
             service = govtRepository.searchServiceById(id);
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return service;
    }

    @Override
    public List<GovtService> searchServices(String query) {
      List<GovtService> allGovtUsers = null;
        try {
            allGovtUsers = govtRepository.queryServices(query);
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allGovtUsers;
    }

    @Override
    public void addUser(GovtUser service) {
        try {
            govtRepository.addUser(service);
            listener.reloadServiceTable();
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<GovtUser> getAllUsers() {
       List<GovtUser> allGovtUsers = null;
       try {
           allGovtUsers = govtRepository.getAllGovtUsers();
       } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
       }
       return allGovtUsers;
    }

    @Override
    public String[] getAllUserTypes() {
       return UserType.userTypes();
    }

    @Override
    public void deleteUser(String id) {
       try {
          govtRepository.removeUser(id);
       } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public void editUser(GovtUser user) {
       try {
           if(user!=null){
                govtRepository.editUser(user);
                listener.reloadServiceTable();

           }
       } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public GovtUser getUserById(String id) {
       GovtUser searchUserById  = null;
       
       try {
           searchUserById = govtRepository.searchUserById(id);
       } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
       }
       return searchUserById;
    }

    @Override
    public ServiceType getServiceTypeById(String id) {
        ServiceType searchForServiceTypeById = null;
        try {
            searchForServiceTypeById = govtRepository.searchForServiceTypeById(id);
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return searchForServiceTypeById;
    }

    @Override
    public void addServiceType(ServiceType serviceType) {
        try {
            govtRepository.addServiceType(serviceType);
            listener.reloadServiceTable();
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ServiceType> getAllAvailableServicesType() {
        List<ServiceType> allServiceTypes = null;
        try {
            allServiceTypes = govtRepository.getAllServiceTypes();
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allServiceTypes;
    }

    @Override
    public void editServiceType(ServiceType service) {
        try {
            govtRepository.editServiceType(service);
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteServiceType(String id) {
        try {
            govtRepository.removeServiceType(id);
        } catch (Exception ex) {
            Logger.getLogger(GovtServicesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
