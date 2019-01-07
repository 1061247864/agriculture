package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = SolrAutoConfiguration.class)
@EnableEurekaClient
@MapperScan("com.mapper")
public class GoodsApp {
	public static void main(String[] args) {
		SpringApplication.run(GoodsApp.class, args);
	}
}
