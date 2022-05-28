package com.fedstation.FedStation.service;

import java.util.List;
import java.util.Optional;

import javax.management.InvalidAttributeValueException;

import com.fedstation.FedStation.dto.MarketplaceItemDetail;
import com.fedstation.FedStation.dto.NewProjectDto;
import com.fedstation.FedStation.entity.ModelType;
import com.fedstation.FedStation.entity.NextAggregationTriggerTime;
import com.fedstation.FedStation.entity.Project;
import com.fedstation.FedStation.entity.UserDetail;
import com.fedstation.FedStation.projection.MarketplaceItemDetailProjection;
import com.fedstation.FedStation.projection.PackageProjectProjection;
import com.fedstation.FedStation.repository.ModelTypeRepo;
import com.fedstation.FedStation.repository.NextAggregationTriggerTimeRepo;
import com.fedstation.FedStation.repository.ProjectRepo;
import com.fedstation.FedStation.repository.UserDetailRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private ModelTypeRepo modelTypeRepo;

    @Autowired
    private UserDetailRepo userDetailRepo;

    @Autowired
    private NextAggregationTriggerTimeRepo nextAggregationTriggerTimeRepo;

    @Override
    public Boolean checkProjectIdExists(String projectId) {
        return projectRepo.checkProjectIdExists(projectId);
    }

    @Override
    public void updateStatusById(String id, String field, Boolean value) {
        if (field.equals("isKeyDisabled")) {
            projectRepo.updateIsKeyDisabledById(value, id);
            return;
        }
        if (field.equals("isProjectDisabled")) {
            projectRepo.updateIsProjectDisabledById(value, id);
        }
    }

    @Override
    public void createNewProject(NewProjectDto project) throws InvalidAttributeValueException {
        ModelType mType = modelTypeRepo.findByModel(project.getModelType()).orElse(null);

        UserDetail userDetail = userDetailRepo.findById(project.getUserId()).orElse(null);

        if (userDetail == null) {
            throw new InvalidAttributeValueException();
        }

        String projectKey = (new HelperServices()).generateKey();

        Project projectRecord = new Project(project.getId(), userDetail, project.getProjectName(),
                project.getProjectDescription(), projectKey, project.getMaxUsersSize(), mType, project.getStartAtTime(),
                project.getTriggerEvery());
        projectRepo.save(projectRecord);

        // increment project count

        userDetailRepo.updateProjectsCount(userDetail.getProjectsCount() + 1, userDetail.getId());

        // update next aggregation time

        System.out.println(
                "\nNext Trigger Time: " + (new HelperServices()).getNextAggregationTimeStamp(projectRecord) + "\n");

        NextAggregationTriggerTime ngt = new NextAggregationTriggerTime();
        ngt.setProjectId(project.getId());
        ngt.setNextAggTimeStamp((new HelperServices()).getNextAggregationTimeStamp(projectRecord));
        nextAggregationTriggerTimeRepo.save(ngt);

    }

    @Override
    public void updateKey(String projectId) throws InvalidAttributeValueException {
        Project project = projectRepo.findById(projectId).orElse(null);
        if (project == null) {
            throw new InvalidAttributeValueException();
        }
        project.setProjectKey((new HelperServices()).generateKey());
        projectRepo.save(project);
    }

    @Override
    public void updateIntAttr(String projectId, String field, Long value) throws InvalidAttributeValueException {
        Project project = projectRepo.findById(projectId).orElse(null);
        if (project == null) {
            throw new InvalidAttributeValueException();
        }

        if (field.equals("triggerEvery")) {
            project.setTriggerEvery(value);
            projectRepo.save(project);
            return;
        }
        if (field.equals("maxUsersSize")) {
            project.setMaxUsersSize(value);
            projectRepo.save(project);
            return;
        }
    }

    @Override
    public PackageProjectProjection getProjectMetaDetails(String projectId, String projectKey) {
        PackageProjectProjection packageProjectProjection = projectRepo.findByIdAndProjectKey(projectId, projectKey)
                .orElse(null);

        if (packageProjectProjection == null)
            return null;

        if (packageProjectProjection.getIsKeyDisabled() == true ||
                packageProjectProjection.getIsProjectDisabled() == true)
            return null;

        return packageProjectProjection;
    }

    @Override
    public void deleteProject(String projectId) throws InvalidAttributeValueException {
        Project project = projectRepo.findById(projectId).orElse(null);

        if (project == null) {
            throw new InvalidAttributeValueException();
        }

        userDetailRepo.updateProjectsCount(project.getUser().getProjectsCount() - 1, project.getUser().getId());

        nextAggregationTriggerTimeRepo.deleteById(project.getId());

        projectRepo.delete(project);
    }

    @Override
    public Project getProject(String projectId) {
        return projectRepo.findById(projectId).orElse(null);
    }

    @Override
    public void updateDescriptionById(String id, String description) throws InvalidAttributeValueException {
        Project project = projectRepo.findById(id).orElse(null);
        if (project == null) {
            throw new InvalidAttributeValueException();
        }
        project.setProjectDescription(description);
        projectRepo.save(project);
    }

    @Override
    public void publishToMarketplace(MarketplaceItemDetail marketplaceItemDetail) throws InvalidAttributeValueException {
        Project project = projectRepo.findById(marketplaceItemDetail.getProjectId()).orElse(null);

        if(project == null){
            throw new InvalidAttributeValueException();
        }

        project.setIsPublished(true);
        project.setMarketplaceItemName(marketplaceItemDetail.getName());
        project.setMarketplaceItemDescription(marketplaceItemDetail.getDescription());
        project.setMarketplaceItemContact(marketplaceItemDetail.getContact());

        projectRepo.save(project);
    }

    @Override
    public List<MarketplaceItemDetailProjection> getMarketplaceModels() {
        
        List<MarketplaceItemDetailProjection> marketplaceItemList = projectRepo.findByIsPublished(true);
        return marketplaceItemList;
    }

}
