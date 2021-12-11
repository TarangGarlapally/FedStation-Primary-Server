package com.fedstation.FedStation.controller;

import java.util.Optional;

import com.fedstation.FedStation.dto.UserDetailDto;
import com.fedstation.FedStation.entity.UserDetail;
import com.fedstation.FedStation.service.ProjectService;
import com.fedstation.FedStation.service.UserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebAppController {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/userDetails")
    public Optional<UserDetailDto> getUserDetails(@RequestParam(name = "userId") String userId) {
        return userDetailService.findByUserId(userId);
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody UserDetail userDetail) {
        userDetailService.createUser(userDetail);
        return "Successfully created user";
    }

    @GetMapping("/projectIdExists")
    public Boolean checkIfProjectIdExists(@RequestParam(name = "projectId") String projectId) {
        return projectService.checkProjectIdExists(projectId);
    }
}
