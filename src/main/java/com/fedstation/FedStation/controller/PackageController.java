package com.fedstation.FedStation.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;

import com.fedstation.FedStation.projection.PackageProjectProjection;
import com.fedstation.FedStation.service.DocumentStorageService;
import com.fedstation.FedStation.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/packageApi")
@CrossOrigin(origins = "*")
public class PackageController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DocumentStorageService documentStorageService;

    @PostMapping("/getProjectDetails")
    public PackageProjectProjection getProjectDetails(@RequestParam(name = "projectId") String projectId,
            @RequestParam(name = "projectKey") String projectKey) {
        return projectService.getProjectMetaDetails(projectId, projectKey);
    }

    @GetMapping("/sendModel")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        documentStorageService.storeFile(file);
    }

    

    public ResponseEntity<Resource> downloadFile(HttpServletRequest request) throws MalformedURLException {

               
        return documentStorageService.loadFileAsResource(request);
    

    