package com.fedstation.FedStation.dto;

public class MonthlyValueDto {
    
    private String month ; 

    private Long value ; 

    public String getMonth(){
        return month ; 
    }

    public Long getValue(){
        return value ; 
    }

    public void setMonth(String month){
        this.month  = month ; 
    }

    public void setValue(Long value){
        this.value  = value ; 
    }
}
