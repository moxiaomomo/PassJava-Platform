package com.moxiaomomo.passjavacontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
// @ComponentScan(basePackages = {"com.moxiaomomo.passjavacontent.config"})
@EnableSwagger2
@SpringBootApplication
public class PassjavaContentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassjavaContentApplication.class, args);
	}

}
