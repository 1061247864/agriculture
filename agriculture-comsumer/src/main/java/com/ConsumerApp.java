package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(basePackages= {"com.service","com.order.service","com.goods.service"})
@EnableEurekaClient
/*@EnableCaching*/
@SpringBootApplication
public class ConsumerApp {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApp.class, args);
	}
}
