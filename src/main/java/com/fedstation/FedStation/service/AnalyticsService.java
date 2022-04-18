package com.fedstation.FedStation.service;

import com.fedstation.FedStation.dto.GlobalModelAnalyticsDto;
import com.fedstation.FedStation.dto.UserAnalyticsDto;

public interface AnalyticsService {
    
    public UserAnalyticsDto getUserAnalytics(String projectId) ; 

    public GlobalModelAnalyticsDto getGlobalModelAnalytics(String projectId);
}
