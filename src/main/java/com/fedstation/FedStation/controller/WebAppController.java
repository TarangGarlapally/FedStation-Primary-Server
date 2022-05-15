package com.fedstation.FedStation.controller;

import java.util.List;
import java.util.Optional;

import javax.management.InvalidAttributeValueException;

import com.fedstation.FedStation.dto.GlobalModelAnalyticsDto;
import com.fedstation.FedStation.dto.MarketplaceItemDetail;
import com.fedstation.FedStation.dto.NewProjectDto;
import com.fedstation.FedStation.dto.UserAnalyticsDto;
import com.fedstation.FedStation.dto.UserDetailDto;
import com.fedstation.FedStation.entity.Project;
import com.fedstation.FedStation.entity.UserDetail;
import com.fedstation.FedStation.projection.MarketplaceItemDetailProjection;
import com.fedstation.FedStation.projection.MonthlyUserCountProjection;
import com.fedstation.FedStation.service.AnalyticsService;
import com.fedstation.FedStation.service.MonthlyUserCountService;
import com.fedstation.FedStation.service.ProjectService;
import com.fedstation.FedStation.service.UserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WebAppController {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MonthlyUserCountService monthlyUserCountService;

    @Autowired
    private AnalyticsService analyticsService  ; 

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

    @GetMapping("/getProject/{projectId}")
    public Project getProject(@PathVariable String projectId) {
        return projectService.getProject(projectId);
    }

    @PatchMapping("/updateStatus")
    public String updateStatus(@RequestParam(name = "projectId") String projectId,
            @RequestParam(name = "field") String field,
            @RequestParam(name = "value") Boolean value) {
        projectService.updateStatusById(projectId, field, value);
        return "Successfully updated " + field;
    }

    @PatchMapping("/updateDescription")
    public String updateDescription(@RequestParam(name = "projectId") String projectId,
            @RequestParam(name = "description") String description) throws InvalidAttributeValueException {
        projectService.updateDescriptionById(projectId, description);
        return "Successfully updated description";
    }

    @PostMapping("/createProject")
    public String createProject(@RequestBody NewProjectDto project) throws InvalidAttributeValueException {
        projectService.createNewProject(project);
        return "Successfully Created Project";
    }

    @PatchMapping("/updateKey/{projectId}")
    public String updateKey(@PathVariable String projectId) throws InvalidAttributeValueException {
        projectService.updateKey(projectId);
        return "Successfully Updated Key";
    }

    @PatchMapping("/updateTriggerOrSize/{projectId}")
    public String updateIntAttr(@PathVariable String projectId, @RequestParam(name = "field") String field,
            @RequestParam(name = "value") Long value) throws InvalidAttributeValueException {
        projectService.updateIntAttr(projectId, field, value);
        return "Successfully Updated " + field;
    }

    @GetMapping("/monthlyUserCountAnalysis/{projectId}")
    public List<MonthlyUserCountProjection> getMonthlyUserCountAnalysis(@PathVariable String projectId) {
        return monthlyUserCountService.getMonthlyUserCountAnalysis(projectId);
    }

    @DeleteMapping("/deleteProject/{projectId}")
    public String deleteProject(@PathVariable String projectId) throws InvalidAttributeValueException {
        projectService.deleteProject(projectId);
        return "Successfully Deleted Project - " + projectId;
    }

    // analytics end points 
    @GetMapping("/userAnalytics/{projectId}")
    public UserAnalyticsDto userAnalytics(@PathVariable String projectId){
        return analyticsService.getUserAnalytics(projectId);
    }

    @GetMapping("/globalModelAnalytics/{projectId}")
    public GlobalModelAnalyticsDto globalModelAnalytics(@PathVariable String projectId){
        return analyticsService.getGlobalModelAnalytics(projectId);
    }

    @PostMapping("/publishToMarketplace")
    public String publishToMarketplace(@RequestBody MarketplaceItemDetail marketplaceItemDetail) throws InvalidAttributeValueException {
        projectService.publishToMarketplace(marketplaceItemDetail);
        return "Successfully published to marketplace";
    }

    @GetMapping("/getMarketplaceModels")
    public List<MarketplaceItemDetailProjection> getMarketplaceModels(){
        return projectService.getMarketplaceModels();
    }

}
