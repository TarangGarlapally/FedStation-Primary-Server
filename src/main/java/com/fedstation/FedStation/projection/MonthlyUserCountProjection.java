package com.fedstation.FedStation.projection;

public interface MonthlyUserCountProjection {

    Long getId();

    String getMonthAndYear();

    Long getUserCount();

}
