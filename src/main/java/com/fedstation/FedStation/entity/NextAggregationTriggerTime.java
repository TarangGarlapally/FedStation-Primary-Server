package com.fedstation.FedStation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NEXT_AGGREGATION_TRIGGER_TIME")
public class NextAggregationTriggerTime {

    @Id
    private String projectId;

    private Long nextAggTimeStamp;

    @Column(columnDefinition = "boolean default false")
    private Boolean isTriggerDisabled = false;

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Long getNextAggTimeStamp() {
        return this.nextAggTimeStamp;
    }

    public void setNextAggTimeStamp(long nextAggTimeStamp) {
        this.nextAggTimeStamp = nextAggTimeStamp;
    }

    public Boolean getIsTriggerDisabled() {
        return this.isTriggerDisabled;
    }

    public void setIsTriggerDisabled(Boolean isTriggerDisabled) {
        this.isTriggerDisabled = isTriggerDisabled;
    }

}
