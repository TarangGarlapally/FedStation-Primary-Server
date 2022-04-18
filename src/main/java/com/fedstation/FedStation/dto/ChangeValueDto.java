package com.fedstation.FedStation.dto;

public class ChangeValueDto {
    private String change = "0%" ; 

    private Double value = (double) 0 ; 

    public String getChange(){
        return change ; 
    }

    public Double getValue(){
        return value ; 
    }

    public void setChange(String change){
        this.change  = change ; 
    }

    public void setValue(Double value){
        this.value  = value ; 
    }
}
