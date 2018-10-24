package com.mruv.activemqconf.domain.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
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
    private Long id;

    @Column(name = "FULL_NAME")
    @JsonSetter("FullName")
    private String fullName;

    @Column(name = "PHONE_NUMBER")
    @JsonSetter("PhoneNumber")
    private String phoneNo;

    @Column(name = "NATIONAL_ID")
    @JsonSetter("NationalId")
    private String natinalId;

    @Column(name = "EMAIL_ADDRESS")
    @JsonSetter("EmailAddress")
    private String emailAddr;

    public SystemUser() {
        id = null;
    }

    @JsonGetter("Id")
    public Long getId() {
        return id;
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter("FullName")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonGetter("PhoneNumber")
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @JsonGetter("NationalId")
    public String getNatinalId() {
        return natinalId;
    }

    public void setNatinalId(String natinalId) {
        this.natinalId = natinalId;
    }

    @JsonGetter("EmailAddress")
    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    @Override
    public String toString() {
        return "SystemUser{" + "id=" + id + ", fullName=" + fullName + ", phoneNo=" + phoneNo + ", natinalId=" + natinalId + ", emailAddr=" + emailAddr + '}';
    }

}
