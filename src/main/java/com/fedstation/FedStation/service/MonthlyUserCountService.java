package com.fedstation.FedStation.service;

import java.util.List;

import com.fedstation.FedStation.projection.MonthlyUserCountProjection;

public interface MonthlyUserCountService {

    public List<MonthlyUserCountProjection> getMonthlyUserCountAnalysis(String projectId);

}
