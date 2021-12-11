package com.fedstation.FedStation.service;

import java.util.Optional;

import com.fedstation.FedStation.entity.UserDetail;
import com.fedstation.FedStation.projection.UserDetailsProjecsProjection;
import com.fedstation.FedStation.repository.UserDetailRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepo userDetailRepo;

    @Override
    public UserDetailsProjecsProjection findByUserId(String userId) {
        return userDetailRepo.getFullDetailsByUserId(userId);
    }

    @Override
    public void createUser(UserDetail userDetail) {
        userDetailRepo.save(userDetail);
    }

}
