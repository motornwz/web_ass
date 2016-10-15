/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monash.fit5042.govtservices;

import com.monash.fit5042.govtservice.entities.GovtUser;
import java.util.List;

public interface UserServiceListener {
    
    public void addUser(GovtUser service);
    public List<GovtUser> getAllUsers();
    public String[] getAllUserTypes();
    public void deleteUser(String id);
    public void editUser(GovtUser id);
    public GovtUser getUserById(String id);
    
}
