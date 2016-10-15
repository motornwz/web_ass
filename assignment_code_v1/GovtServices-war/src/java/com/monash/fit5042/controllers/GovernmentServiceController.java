package com.monash.fit5042.controllers;

import com.monash.fit5042.govtservice.entities.GovtService;
import fit5042.tutex.mbeans.GovtServiceManagedBean;
import java.util.Map;
import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

/**
 *
 * @author Naveed Zanoon
 */
@Named(value = "serviceController")
@SessionScoped
public class GovernmentServiceController {

    private String pageTitle;
    private int serviceID;
    private GovtService service;
    private boolean addState;
    
    private DataModel items = null;

    
    public GovernmentServiceController() {
        
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public GovtService getServiceId(int serviceID) {
        GovtService retVal;

        ELContext context = FacesContext.getCurrentInstance().getELContext();
        GovtServiceManagedBean app
                = (GovtServiceManagedBean) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "govtServiceManagedBean");
        
        retVal = app.getAllServices().get((int) serviceID);

        return retVal;
    }

    public GovtService getService() {
        return service;
    }

    public void setService(GovtService service) {
        this.service = service;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public boolean isAddState() {
        return addState;
    }

    public void setAddState(boolean addState) {
        this.addState = addState;
    }

//    public String viewServiceActionLink() {
//
//        Map<String, Object> requestParameterMap = FacesContext.getCurrentInstance()
//                .getExternalContext().getSessionMap();
//        if (requestParameterMap.containsKey("serviceID")) {
//            String serviceID = (String) requestParameterMap.get("serviceID");
//            service = getServiceId(Integer.valueOf(serviceID));
//            pageTitle = service.getServiceName();
//        }
//        return "governmentservice";
//    }
    
    public String getView(int id){
        serviceID = id;
        return "governmentservice";
    }

}
