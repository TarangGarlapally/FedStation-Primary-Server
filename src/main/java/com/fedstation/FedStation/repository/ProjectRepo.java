package com.fedstation.FedStation.repository;

import java.util.List;

import com.fedstation.FedStation.entity.Project;
import com.fedstation.FedStation.projection.ProjectProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, String> {

    @Query(value = "select exists(select 1 from Project p where p.id = ?1)", nativeQuery = true)
    Boolean checkProjectIdExists(String id);

    List<ProjectProjection> findAllByUserId(String userId);

}
