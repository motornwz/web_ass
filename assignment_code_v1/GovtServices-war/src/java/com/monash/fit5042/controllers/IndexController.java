/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monash.fit5042.controllers;

import fit5042.tutex.mbeans.GovtServiceManagedBean;
import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Naveed Zanoon
 */
@Named(value = "indexController")
@RequestScoped
public class IndexController {

    private String pageTitle;
    private DataModel items = null;
    private GovtServiceManagedBean app;
    
    public IndexController() {
        pageTitle = "Viewing Services";
        ELContext context = FacesContext.getCurrentInstance().getELContext();
        
        app = (GovtServiceManagedBean) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "govtServiceManagedBean");
    }
    
    public DataModel getItems() {
        if (items == null) {
            items = new ListDataModel(app.getAllServices());
        }
        return items;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}
