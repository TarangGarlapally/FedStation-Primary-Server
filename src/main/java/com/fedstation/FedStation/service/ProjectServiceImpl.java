package com.fedstation.FedStation.service;

import com.fedstation.FedStation.repository.ProjectRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public Boolean checkProjectIdExists(String projectId) {
        return projectRepo.checkProjectIdExists(projectId);
    }

}
