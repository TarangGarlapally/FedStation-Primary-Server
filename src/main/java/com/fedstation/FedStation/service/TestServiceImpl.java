package com.fedstation.FedStation.service;

import java.util.Optional;

import com.fedstation.FedStation.entity.UserDetail;
import com.fedstation.FedStation.repository.UserDetailRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserDetailRepo userDetailRepo;

    @Override
    public Optional<UserDetail> testMethod() {
        return userDetailRepo.findById("test");
    }

}
