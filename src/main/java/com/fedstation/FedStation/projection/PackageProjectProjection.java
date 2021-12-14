package com.fedstation.FedStation.projection;

import com.fedstation.FedStation.entity.ModelType;

public interface PackageProjectProjection {

    //respone to package project details 
    String getId() ; 
    String getProjectDescription() ; 
    ModelType getModelType() ; 
    String getStartAtTime() ;
    String getTriggerEvery() ;
    Boolean getIsKeyDisabled() ; 
    Boolean getIsProjectDisabled() ; 

}
