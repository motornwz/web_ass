package com.monash.fit5042.govtservice.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Naveed Zanoon
 */
@Entity
@Table(name = "govt_service_use")
public class GovtServiceUse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //ID number of the member of Public using the service
    @Column(name = "public_member_id")
    private Long publicMemberId;
    
    //Date when the service is used
    @Column(name = "service_use")
    private Long serviceUse;
    
    //The services that the service use include
    @JoinColumn
    @ManyToOne
    private GovtService serviceUsed;
    
    //Government Worker linked to the Service/transaction
    @Column(name = "govt_worker_id")
    private Long govtWorkedId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GovtServiceUse)) {
            return false;
        }
        GovtServiceUse other = (GovtServiceUse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.monash.fit5042.govtservice.entities.GovtServiceUse[ id=" + id + " ]";
    }

    public Long getPublicMemberId() {
        return publicMemberId;
    }

    public void setPublicMemberId(Long publicMemberId) {
        this.publicMemberId = publicMemberId;
    }

    public Long getServiceUse() {
        return serviceUse;
    }

    public void setServiceUse(Long serviceUse) {
        this.serviceUse = serviceUse;
    }

    public GovtService getServiceIds() {
        return serviceUsed;
    }

    public void setServiceIds(GovtService serviceIds) {
        this.serviceUsed = serviceIds;
    }

    public Long getGovtWorkedId() {
        return govtWorkedId;
    }

    public void setGovtWorkedId(Long govtWorkedId) {
        this.govtWorkedId = govtWorkedId;
    }
    
}
