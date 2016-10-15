/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monash.fit5042.govtservice.entities;

/**
 *
 * @author Naveed Zanoon
 */
public abstract class BaseModel {
    
    public abstract boolean isValid() throws GovtServiceException;
}
