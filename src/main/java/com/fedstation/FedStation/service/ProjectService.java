package com.fedstation.FedStation.service;

public interface ProjectService {

    public Boolean checkProjectIdExists(String projectId);

    public void updateStatusById(String id, String field, Boolean value);

}
