package com.fedstation.FedStation.utilities;

import java.io.FileNotFoundException;
import java.util.List;

import com.google.api.client.http.HttpHeaders;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

public class FirebaseStorageUtil {
    
    public void dowloadGlobalModelFromFirebase(String projectId) throws FileNotFoundException{
        String uri  = "https://fedstation-ml-service.herokuapp.com/dowloadGlobalModelFromFirebase/" + projectId;
        RestTemplate restTemplate = new RestTemplate() ; 
        ResponseEntity<Object> response = restTemplate.getForEntity(uri, Object.class) ; 
        System.out.print(response.getBody() + " result");
    }

    public void sendModelsToFirebase(String projectId , List<MultipartFile> models) throws FileNotFoundException{

        // headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA.toString());

        // body 
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>(); 
        body.add("headers", headers);

        for(MultipartFile model : models){
            System.out.println(model.getName());
            body.add(projectId , model);
        }

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body);
        
        String uri  = "https://fedstation-ml-service.herokuapp.com/uploadModelsToFirebase/" + projectId;
        RestTemplate restTemplate = new RestTemplate() ; 
        ResponseEntity<String> response = restTemplate.postForEntity(uri, requestEntity, String.class) ; 
        System.out.print(response + " result");
        
    }

}
