package com.fedstation.FedStation.repository;

import java.util.Optional;

import com.fedstation.FedStation.entity.UserDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepo extends JpaRepository<UserDetail, String> {
    Optional<UserDetail> findById(String id);
}
