package com.fedstation.FedStation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "MONTHLY_USER_COUNT")
public class MonthlyUserCount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Project project;

    private String monthAndYear;

    private Long month ; 

    private Long userCount;

    private Long modelScore ; 
    
    private Long modelSize  ; 

    public Project getProject() {
        return this.project;
    }

    public String getMonthAndYear() {
        return this.monthAndYear;
    }

    public Long getMonth(){
        return this.month ; 
    }
    public Long getUserCount() {
        return this.userCount;
    }

    public Long getModelScore(){
        return this.modelScore  ; 
    }

    public Long getModelSize(){
        return this.modelSize ; 
    }

}
