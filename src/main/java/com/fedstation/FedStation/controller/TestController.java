package com.fedstation.FedStation.controller;

import java.util.Optional;

import com.fedstation.FedStation.entity.UserDetail;
import com.fedstation.FedStation.service.TestServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestServiceImpl testServiceImpl;

    @GetMapping("/test")
    public Optional<UserDetail> testPath() {
        return testServiceImpl.testMethod();
    }
}
