package com.fedstation.FedStation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class FedStationPrimaryServerApplication {


	@GetMapping("/hello")
	public String hello() {
		return "Hello!";
	}

	public static void main(String[] args) {
		SpringApplication.run(FedStationPrimaryServerApplication.class, args);
	}

}
