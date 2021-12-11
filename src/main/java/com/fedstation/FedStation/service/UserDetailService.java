package com.fedstation.FedStation.service;

import java.util.Optional;

import com.fedstation.FedStation.dto.UserDetailDto;
import com.fedstation.FedStation.entity.UserDetail;

public interface UserDetailService {

    public Optional<UserDetailDto> findByUserId(String userId);

    public void createUser(UserDetail userDetail);

}
