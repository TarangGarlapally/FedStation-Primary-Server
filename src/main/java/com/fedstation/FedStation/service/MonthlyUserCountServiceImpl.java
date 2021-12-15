package com.fedstation.FedStation.service;

import java.util.List;

import com.fedstation.FedStation.entity.Project;
import com.fedstation.FedStation.projection.MonthlyUserCountProjection;
import com.fedstation.FedStation.repository.MonthlyUserCountRepo;
import com.fedstation.FedStation.repository.ProjectRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MonthlyUserCountServiceImpl implements MonthlyUserCountService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private MonthlyUserCountRepo monthlyUserCountRepo;

    @Override
    public List<MonthlyUserCountProjection> getMonthlyUserCountAnalysis(String projectId) {
        Project project = projectRepo.findById(projectId).orElse(null);
        if (project == null)
            return null;

        return monthlyUserCountRepo.findByProject(project);
    }

}
