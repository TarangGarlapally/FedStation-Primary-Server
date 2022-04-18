package com.fedstation.FedStation.dto;

import org.springframework.stereotype.Component;

/*

{
  current_model_score : {
    value : 1000, 
    change : 25%
  },
  average_model_score : {
    value : 1000, 
    change :25%
  },
  best_model_score: {
    value : 1000, 
    change :25%
  }, 
  OVERRALL_PERFORMANCE : 25,
  monthly_model_score : [
    {
        month : "JAN", 
        value: 1000
    }....
  ],
  model_montly_storage: [
    {
        month : "JAN", 
        value: 1000
    }....
  ]
  
}

*/
@Component
public class GlobalModelAnalyticsDto {
    private String projectId ; 

    public void calc(String projectId){
      this.projectId = projectId ; 
    }

    public String getProjectId(){
      return this.projectId ; 
    }
}
