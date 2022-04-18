package com.fedstation.FedStation.service;

import com.fedstation.FedStation.dto.GlobalModelAnalyticsDto;
import com.fedstation.FedStation.dto.UserAnalyticsDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    @Autowired
    private UserAnalyticsDto userAnalyticsDto ; 

    @Autowired
    private GlobalModelAnalyticsDto globalModelAnalyticsDto ; 

    @Override
    public UserAnalyticsDto getUserAnalytics(String projectId) {
        userAnalyticsDto.calc(projectId);
        return userAnalyticsDto ; 
        
    }

    @Override
    public GlobalModelAnalyticsDto getGlobalModelAnalytics(String projectId) {

       globalModelAnalyticsDto.calc(projectId);
       return globalModelAnalyticsDto ; 
    }
    
}
