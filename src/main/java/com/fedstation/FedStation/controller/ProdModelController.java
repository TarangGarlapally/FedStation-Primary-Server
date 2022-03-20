package com.fedstation.FedStation.controller;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prodModel")
public class ProdModelController {

    @PostMapping("/getModelResult")
    public JsonNode getModelResult(@RequestParam(name = "modelInput") JsonNode modelInput) {
        return null;
    }

}
