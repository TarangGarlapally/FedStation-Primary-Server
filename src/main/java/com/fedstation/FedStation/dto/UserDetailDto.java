package com.fedstation.FedStation.dto;

import java.util.List;

import com.fedstation.FedStation.projection.ProjectProjection;

public class UserDetailDto {

    private String id;

    private String fname;

    private String lname;

    private String email;

    private String org;

    private Long projectsCount;

    private List<ProjectProjection> projectsList;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Long getProjectsCount() {
        return this.projectsCount;
    }

    public void setProjectsCount(Long projectsCount) {
        this.projectsCount = projectsCount;
    }

    public List<ProjectProjection> getProjectsList() {
        return this.projectsList;
    }

    public void setProjectsList(List<ProjectProjection> projectsList) {
        this.projectsList = projectsList;
    }

}
