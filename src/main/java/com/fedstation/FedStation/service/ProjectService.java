package com.fedstation.FedStation.service;

import javax.management.InvalidAttributeValueException;

import com.fedstation.FedStation.dto.NewProjectDto;
import com.fedstation.FedStation.entity.Project;
import com.fedstation.FedStation.projection.PackageProjectProjection;

public interface ProjectService {

    public Boolean checkProjectIdExists(String projectId);

    public void updateStatusById(String id, String field, Boolean value);

    public void updateDescriptionById(String id, String description) throws InvalidAttributeValueException;

    public void createNewProject(NewProjectDto project) throws InvalidAttributeValueException;

    public void updateKey(String projectId) throws InvalidAttributeValueException;

    public void updateIntAttr(String projectId, String field, Long value) throws InvalidAttributeValueException;

    public PackageProjectProjection getProjectMetaDetails(String projectId, String projectKey);

    public void deleteProject(String projectId) throws InvalidAttributeValueException;

    public Project getProject(String projectId);
}
