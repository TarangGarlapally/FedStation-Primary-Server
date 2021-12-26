package com.fedstation.FedStation.service;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentStorageService {
    public void storeFile(MultipartFile file) throws IOException;
    public ResponseEntity<Resource> loadFileAsResource(HttpServletRequest request) throws MalformedURLException; 
}
