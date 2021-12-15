package com.fedstation.FedStation.repository;

import java.util.List;

import com.fedstation.FedStation.entity.MonthlyUserCount;
import com.fedstation.FedStation.entity.Project;
import com.fedstation.FedStation.projection.MonthlyUserCountProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyUserCountRepo extends JpaRepository<MonthlyUserCount, Long> {

    List<MonthlyUserCountProjection> findByProject(Project project);

}
