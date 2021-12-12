package com.fedstation.FedStation.dto;

public class NewProjectDto {

    private String id;

    private String userId;

    private String projectName;

    private String projectDescription;

    private Long maxUsersSize;

    private String modelType;

    private String startAtTime;

    private Long triggerEvery;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return this.projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Long getMaxUsersSize() {
        return this.maxUsersSize;
    }

    public void setMaxUsersSize(Long maxUsersSize) {
        this.maxUsersSize = maxUsersSize;
    }

    public String getModelType() {
        return this.modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getStartAtTime() {
        return this.startAtTime;
    }

    public void setStartAtTime(String startAtTime) {
        this.startAtTime = startAtTime;
    }

    public Long getTriggerEvery() {
        return this.triggerEvery;
    }

    public void setTriggerEvery(Long triggerEvery) {
        this.triggerEvery = triggerEvery;
    }

}