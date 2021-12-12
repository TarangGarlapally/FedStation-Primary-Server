package com.fedstation.FedStation.repository;

import java.util.Optional;

import com.fedstation.FedStation.entity.ModelType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelTypeRepo extends JpaRepository<ModelType, Long> {

    Optional<ModelType> findByModel(String model);

}
