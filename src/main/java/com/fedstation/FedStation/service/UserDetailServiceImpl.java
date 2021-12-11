package com.fedstation.FedStation.service;

import java.util.Optional;

import com.fedstation.FedStation.entity.UserDetail;
import com.fedstation.FedStation.repository.UserDetailRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepo userDetailRepo;

    @Override
    public Optional<UserDetail> findByUserId(String userId) {
        return userDetailRepo.findById(userId);
    }

}
