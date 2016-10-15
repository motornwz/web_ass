/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.mbeans;

import com.monash.fit5042.govtservice.entities.GovtService;
import com.monash.fit5042.govtservice.repository.GovtServiceRepository;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author Naveed Zanoon
 */
@ManagedBean(name = "govtServiceManagedBean")
@ApplicationScoped
public class GovtServiceManagedBean implements Serializable {

    @EJB
    GovtServiceRepository serviceRepo;
    
    public GovtServiceManagedBean() {
    }
    
    public List<GovtService> getAllServices(){
        try {
            return serviceRepo.getAllServices();
        } catch (Exception ex) {
            Logger.getLogger(GovtServiceManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
}
