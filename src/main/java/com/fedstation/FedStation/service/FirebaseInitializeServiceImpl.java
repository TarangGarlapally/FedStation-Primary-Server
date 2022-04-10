package com.fedstation.FedStation.service;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.stereotype.Service;

@Service
public class FirebaseInitializeServiceImpl  implements FirebaseInitializeService{

    @Override
    @PostConstruct
    public void initialize() {
        try{
            
            FileInputStream serviceAccount =
            new FileInputStream("../../../../../resources/service_account.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();

            FirebaseApp.initializeApp(options);

            System.out.println("CONNECTED TO FIREBASE");

        }
        catch(Exception e){
            System.out.println("UNABLE TO CONNECT FIREBASE");
            e.printStackTrace();
        }
        
    }
    
}
