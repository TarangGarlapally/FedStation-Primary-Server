package com.fedstation.FedStation.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AggregationServiceImpl implements AggregationService{

    @Override
    public void callAggregate(String projectId) {

        System.out.print("ENTERED");
        String uri  = "https://fedstation-ml-service.herokuapp.com/aggregate/" + "k_k"; 
        RestTemplate restTemplate = new RestTemplate() ; 
        String result = restTemplate.getForObject(uri, String.class) ; 
        System.out.print(result + " result");
        
    }
    
}
