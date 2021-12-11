package com.fedstation.FedStation.service;

import java.util.Optional;

import com.fedstation.FedStation.entity.UserDetail;
import com.fedstation.FedStation.repository.UserDetailRepo;
import com.fedstation.FedStation.repository.ProjectRepo;
import com.fedstation.FedStation.dto.UserDetailDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepo userDetailRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public Optional<UserDetailDto> findByUserId(String userId) {

        UserDetail userDetail = userDetailRepo.findById(userId).orElse(null);

        if (userDetail == null) {
            return null;
        }

        UserDetailDto userDetailDto = new UserDetailDto();
        userDetailDto.setEmail(userDetail.getEmail());
        userDetailDto.setFname(userDetail.getFname());
        userDetailDto.setLname(userDetail.getLname());
        userDetailDto.setId(userDetail.getId());
        userDetailDto.setOrg(userDetail.getOrg());
        userDetailDto.setProjectsCount(userDetail.getProjectsCount());
        userDetailDto.setProjectsList(projectRepo.findAllByUserId(userId));
        return Optional.of(userDetailDto);
    }

    @Override
    public void createUser(UserDetail userDetail) {
        userDetailRepo.save(userDetail);
    }

}
