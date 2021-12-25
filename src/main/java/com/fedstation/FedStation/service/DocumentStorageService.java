package com.fedstation.FedStation.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentStorageService {
    public void storeFile(MultipartFile file) throws IOException;
    public Resource loadFileAsResource() throws MalformedURLException; 
}
