package com.fedstation.FedStation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project {
    @Id
    private String id;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private UserDetail user;

    private String projectName;

    private String projectDescription;

    private String projectKey;

    private Long maxUsersSize;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private ModelType modelType;

    private String startAtTime;

    private Long triggerEvery;

    private String recieveAt;

    @Column(columnDefinition = "boolean default false")
    private Boolean isProjectDisabled = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean isKeyDisabled = false;

    public Boolean getIsProjectDisabled() {
        return this.isProjectDisabled;
    }

    public void setIsProjectDisabled(Boolean isProjectDisabled) {
        this.isProjectDisabled = isProjectDisabled;
    }

    public Boolean getIsKeyDisabled() {
        return this.isKeyDisabled;
    }

    public void setIsKeyDisabled(Boolean isKeyDisabled) {
        this.isKeyDisabled = isKeyDisabled;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDetail getUser() {
        return this.user;
    }

    public void setUser(UserDetail user) {
        this.user = user;
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

    public String getProjectKey() {
        return this.projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public Long getMaxUsersSize() {
        return this.maxUsersSize;
    }

    public void setMaxUsersSize(Long maxUsersSize) {
        this.maxUsersSize = maxUsersSize;
    }

    public ModelType getModelType() {
        return this.modelType;
    }

    public void setModelType(ModelType modelType) {
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

    public String getRecieveAt() {
        return this.recieveAt;
    }

    public void setRecieveAt(String recieveAt) {
        this.recieveAt = recieveAt;
    }

    protected Project() {
    }

    public Project(String id, UserDetail userDetail, String projectName, String projectDescription, String projectKey,
            Long maxUsersSize, ModelType modelType, String startAtTime, Long triggerEvery) {
        this.id = id;
        this.maxUsersSize = maxUsersSize;
        this.modelType = modelType;
        this.projectDescription = projectDescription;
        this.projectKey = projectKey;
        this.projectName = projectName;
        this.startAtTime = startAtTime;
        this.triggerEvery = triggerEvery;
        this.user = userDetail;
    }

}
