package com.fedstation.FedStation.controller;

import com.fedstation.FedStation.projection.PackageProjectProjection;
import com.fedstation.FedStation.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packageApi")
@CrossOrigin(origins = "*")
public class PackageController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/getProjectDetails")
    public PackageProjectProjection getProjectDetails(@RequestParam(name = "projectId") String projectId,
            @RequestParam(name = "projectKey") String projectKey) {
        return projectService.getProjectMetaDetails(projectId, projectKey);
    }
}
