package com.fedstation.FedStation.projection;

import com.fedstation.FedStation.entity.ModelType;

public interface ProjectProjection {

    String getId();

    String getProjectName();

    String getProjectDescription();

    String getProjectKey();

    Long getMaxUsersSize();

    ModelType getModelType();

    String getStartAtTime();

    Long getTriggerEvery();

}
