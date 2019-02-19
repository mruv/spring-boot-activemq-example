package com.mruv.activemqconf.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class SystemUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @JsonProperty("Id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @Column(name = "FULL_NAME")
    @JsonProperty("FullName")
    private String fullName;

    @Column(name = "PHONE_NUMBER")
    @JsonProperty("PhoneNumber")
    private String phoneNo;

    @Column(name = "NATIONAL_ID")
    @JsonProperty("NationalId")
    private String natinalId;

    @Column(name = "EMAIL_ADDRESS")
    @JsonProperty("EmailAddress")
    private String emailAddr;

    public SystemUser() {
        id = null;
    }

    public Long getId() {
        return id;
    }
    
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getNatinalId() {
        return natinalId;
    }

    public void setNatinalId(String natinalId) {
        this.natinalId = natinalId;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }
}
