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

    @Column(columnDefinition = "boolean default false")
    private Boolean isProjectDisabled = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean isKeyDisabled = false;

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

    public Boolean getIsProjectDisabled() {
        return this.isProjectDisabled;
    }

    public Boolean getIsKeyDisabled() {
        return this.isKeyDisabled;
    }

    public String getid() {
        return this.id;
    }

    public UserDetail getUser() {
        return this.user;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public String getProjectDescription() {
        return this.projectDescription;
    }

    public String getProjectKey() {
        return this.projectKey;
    }

    public Long getMaxUsersSize() {
        return this.maxUsersSize;
    }

    public ModelType getModelType() {
        return this.modelType;
    }

    public String getStartAtTime() {
        return this.startAtTime;
    }

    public Long getTriggerEvery() {
        return this.triggerEvery;
    }

}
