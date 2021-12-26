package com.fedstation.FedStation.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class DocumentStorageServiceImpl implements DocumentStorageService {
    

    private final String modelFileName = "Model.pkl" ;
    
    private final Path fileStorageLocation = Paths.get("D:/Projects/FedStation-Primary-Server/src/storage").toAbsolutePath().normalize();
    @Override
    public void storeFile(MultipartFile file) throws IOException {
        // stores file content into   storage/Model.pkl  

        Path targetLocation  = this.fileStorageLocation.resolve(this.modelFileName) ; 
        
    
        Files.copy(file.getInputStream(), targetLocation  , StandardCopyOption.REPLACE_EXISTING);
        
    }

    @Override
    public ResponseEntity<Resource> loadFileAsResource(HttpServletRequest request) throws MalformedURLException {
        Path targetLocation = this.fileStorageLocation.resolve(this.modelFileName) ; 
        Resource resource  = new UrlResource(targetLocation.toUri()) ; 
        String contentType  = null ; 

        try{
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath()) ; 
        }
        catch (IOException ex){
            //pass
        }


        //ignore - used for temporary working 
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
        .body(resource);
 
    }
    
}
