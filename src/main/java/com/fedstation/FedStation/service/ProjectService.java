package com.fedstation.FedStation.service;

import javax.management.InvalidAttributeValueException;

import com.fedstation.FedStation.dto.NewProjectDto;

public interface ProjectService {

    public Boolean checkProjectIdExists(String projectId);

    public void updateStatusById(String id, String field, Boolean value);

    public void createNewProject(NewProjectDto project) throws InvalidAttributeValueException;
}
