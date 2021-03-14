package com.borelanjo.aulapos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
public class PacienteConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteConsumerApplication.class, args);
	}

}
