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

    private String nextAggTimeStamp;

    @Column(columnDefinition = "boolean default false")
    private Boolean isTriggerDisabled = false;

    public Object getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getNextAggTimeStamp() {
        return this.nextAggTimeStamp;
    }

    public void setNextAggTimeStamp(String nextAggTimeStamp) {
        this.nextAggTimeStamp = nextAggTimeStamp;
    }

    public Boolean getIsTriggerDisabled() {
        return this.isTriggerDisabled;
    }

    public void setIsTriggerDisabled(Boolean isTriggerDisabled) {
        this.isTriggerDisabled = isTriggerDisabled;
    }

}
