package com.fedstation.FedStation.service;

import java.util.Optional;

import com.fedstation.FedStation.entity.UserDetail;

public interface UserDetailService {

    public Optional<UserDetail> findByUserId(String userId);

    public void createUser(UserDetail userDetail);

}
