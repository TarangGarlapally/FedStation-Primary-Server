package com.fedstation.FedStation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MODEL_TYPE")
public class ModelType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;

    private String aggregationType;

    public Long getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    public Object getAggregationType() {
        return this.aggregationType;
    }

}
