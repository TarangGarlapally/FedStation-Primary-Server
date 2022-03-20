package com.fedstation.FedStation.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.fedstation.FedStation.entity.NextAggregationTriggerTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NextAggregationTriggerTimeRepo extends JpaRepository<NextAggregationTriggerTime, String> {

    @Modifying
    @Transactional
    @Query("update NextAggregationTriggerTime ngt set ngt.nextAggTimeStamp = ?1 where ngt.projectId = ?2")
    void updateTimeStampByProjectID(Long nextAggTimeStamp, String projectId);

    List<NextAggregationTriggerTime> findByNextAggTimeStamp(Long nextAggTimeStamp);

}
