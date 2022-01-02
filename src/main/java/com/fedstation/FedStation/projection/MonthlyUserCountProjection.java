package com.fedstation.FedStation.projection;

public interface MonthlyUserCountProjection {

    Long getId();

    Long getMonth() ; 
    
    String getMonthAndYear();

    Long getUserCount();

    Long getModelScore(); 

    Long getModelSize() ; 

}
