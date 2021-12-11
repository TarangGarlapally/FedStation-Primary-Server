package com.fedstation.FedStation.repository;

import java.util.Optional;

import com.fedstation.FedStation.entity.UserDetail;
import com.fedstation.FedStation.projection.ProjectProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepo extends JpaRepository<UserDetail, String> {

    Optional<UserDetail> findById(String id);

    @Query(value = "select * from user_detail u, project p where p.user_id = u.id and u.id = ?1", nativeQuery = true)
    ProjectProjection getFullDetailsByUserId(String id);

}
