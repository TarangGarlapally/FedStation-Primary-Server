package com.fedstation.FedStation.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fedstation.FedStation.entity.MonthlyUserCount;
import com.fedstation.FedStation.projection.MonthlyUserCountProjection;
import com.fedstation.FedStation.service.MonthlyUserCountService;
import com.fedstation.FedStation.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*

{
  current_active_users  : {
    value : 1000, 
    change : 25%
  }
  average_active_users : {
    value : 1000, 
    change :25%
  }
  MAX_ACTIVE_USERS : 3000, 
  monthly_active_users : [
    {
        month : "JAN", 
        value: 1000
    }....
  ],
  extra_active_users : [
    {
        month : "JAN", 
        value: 1000
    }....
  ]
  
}

*/

@Component
public class UserAnalyticsDto {
    private String projectId ; 
    private Long maxActiveUsers ; 
    private ChangeValueDto currentActiveUsers ; 
    private ChangeValueDto averageActiveUsers ; 
    private List<MonthlyValueDto> monthlyActiveUsers ; 
    private List<MonthlyValueDto> extraActiveUsers ; 

    @Autowired 
    private ProjectService projectService ; 

    @Autowired
    private MonthlyUserCountService monthlyUserCountService ; 

    private Map<Long,String> monthMapper ; 

    public void calc(String projectId){
      this.projectId = projectId  ; 
      this.maxActiveUsers = projectService.getProject(projectId).getMaxUsersSize() ; 
    
      List<MonthlyUserCountProjection> monthlyUserCountProjections = monthlyUserCountService.getMonthlyUserCountAnalysis(projectId);

      System.out.println(monthlyUserCountProjections.size());

      this.monthlyActiveUsers = new ArrayList<>() ; 
      this.extraActiveUsers = new ArrayList<>();
      this.currentActiveUsers = new ChangeValueDto(); 
      this.averageActiveUsers = new ChangeValueDto(); 

      monthMapper = new HashMap<>(); 

      monthMapper.put((long) 1, "JAN");
      monthMapper.put((long) 2, "FEB"); 
      monthMapper.put((long) 3, "MAR");
      monthMapper.put((long) 4, "APR");
      monthMapper.put((long) 5, "MAY");
      monthMapper.put((long) 6, "JUN");
      monthMapper.put((long) 7, "JUL");
      monthMapper.put((long) 8, "AUG");
      monthMapper.put((long) 9, "SEP");
      monthMapper.put((long) 10, "OCT");
      monthMapper.put((long) 11, "NOV");
      monthMapper.put((long) 12, "DEC");

      for(MonthlyUserCountProjection m : monthlyUserCountProjections){
        MonthlyValueDto monthlyValueDto = new MonthlyValueDto(); 
        monthlyValueDto.setMonth(monthMapper.get(m.getMonth()));
        monthlyValueDto.setValue(m.getUserCount());
        monthlyActiveUsers.add(monthlyValueDto);

        MonthlyValueDto extraDto = new MonthlyValueDto() ; 
        extraDto.setMonth(monthMapper.get(m.getMonth()));
        extraDto.setValue(m.getUserCount() - this.maxActiveUsers);
        extraActiveUsers.add(extraDto);
      }

      // sort monthlyUserCount 
      Long mucSize = (long) monthlyActiveUsers.size() ;


      //UC Value Analytics
      if(mucSize > 0 ){
        Double previousMonthAUC = (double) 0 ; 
        Double currentMonthAUC = (double) 0  ; 
  
        
  
        for(int i = 0 ; i < mucSize ; i++){
            currentMonthAUC += monthlyActiveUsers.get(i).getValue() ;
            if(i != mucSize-1)
            previousMonthAUC += monthlyActiveUsers.get(i).getValue() ;
        }
  
        currentMonthAUC /= mucSize ; 
        this.averageActiveUsers.setValue(currentMonthAUC);
  
        if(mucSize >1){
          previousMonthAUC /= (mucSize -1) ; 
          Double change  = ((currentMonthAUC - previousMonthAUC)/previousMonthAUC ) ; 
  
          this.averageActiveUsers.setChange(
            String.format( 
              "%.2f",
              change
            ) + "%"
          )  ;
        }
  
        Double currentMonthUC = (double) monthlyActiveUsers.get((int) (mucSize-1)).getValue()  ; 
        this.currentActiveUsers.setValue(currentMonthUC);
  
        if(mucSize > 1){
          Double previousMonthUC = (double) monthlyActiveUsers.get((int) (mucSize-2)).getValue() ; 
          Double change  = ((currentMonthUC - previousMonthUC)/previousMonthUC ) ; 
  
          this.currentActiveUsers.setChange(
            String.format( 
              "%.2f",
              change
            ) + "%"
          )  ;
        }
      }

    }
    public String getProjectId(){
      return this.projectId ; 
    }

    public Long getMaxActiveUsers(){
      return this.maxActiveUsers ; 
    }

    public ChangeValueDto getCurrentActiveUsers(){
      return this.currentActiveUsers ; 
    }

    public ChangeValueDto getAverageActiveUsers(){
      return this.averageActiveUsers ; 
    }

    public List<MonthlyValueDto> getmonthlyActiveUsers(){
      return this.monthlyActiveUsers ; 
    }

    public List<MonthlyValueDto> getExtraActiveUsers(){
      return this.extraActiveUsers ; 
    }
    
}
