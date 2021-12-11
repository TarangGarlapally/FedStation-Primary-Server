package com.fedstation.FedStation.projection;

import java.util.List;

import com.fedstation.FedStation.entity.Project;

public interface UserDetailsProjecsProjection {

    String getId();

    String getFname();

    String getLname();

    String getEmail();

    String getOrg();

    Long getProjectsCount();

    List<Project> getProjects();

}
