package com.monash.fit5042.govtservice.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Naveed Zanoon
 */
@Entity
@Table(name = "govt_user")
@NamedQueries({
    @NamedQuery(name = GovtUser.GET_ALL_QUERY_NAME, query = "SELECT u FROM GovtUser u")})
public class GovtUser extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String GET_ALL_QUERY_NAME = "GovtUser.getAll";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    @NotNull
    private String emailAddress;

    @NotNull
    private String password;
    
    private String type;
    private String address;
    private String phoneNumber;

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
        if (!(object instanceof GovtUser)) {
            return false;
        }
        GovtUser other = (GovtUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.monash.fit5042.govtservice.entities.GovtUser[ id=" + id + " ]";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isValid() throws GovtServiceException {
        boolean retVal = false;

        retVal = isNameValid() && isPhoneNumberValid();

        return retVal;
    }
    
    private boolean isNameValid(){
       return firstName != null && lastName != null 
               && firstName.length()>0 && lastName.length() >0;
    }
    
    private boolean isPhoneNumberValid(){
        return phoneNumber!=null && phoneNumber.length()>0;
    }
    
}
