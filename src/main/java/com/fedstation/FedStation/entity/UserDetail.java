package com.fedstation.FedStation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAIL")
public class UserDetail {
    @Id
    private String id;

    private String fname;

    private String lname;

    private String email;

    private String org;
    
    private Long projectsCount;

    public String getId() {
        return this.id;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getOrg() {
        return this.org;
    }

    public Long getProjectsCount() {
        return this.projectsCount;
    }

}
