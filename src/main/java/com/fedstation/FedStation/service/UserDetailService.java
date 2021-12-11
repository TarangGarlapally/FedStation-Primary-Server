package com.fedstation.FedStation.service;

import java.util.Optional;

import com.fedstation.FedStation.entity.UserDetail;
import com.fedstation.FedStation.projection.UserDetailsProjecsProjection;

public interface UserDetailService {

    public UserDetailsProjecsProjection findByUserId(String userId);

    public void createUser(UserDetail userDetail);

}
