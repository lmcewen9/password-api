package com.lukemcewen.morrgan_api;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MorrganApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MorrganApiApplication.class, args);
	}

	@Bean
	DataSource dataSource(DataSourceProperties properties){
		var db = DataSourceBuilder
					.create()
					.url(properties.getUrl())
					.username(properties.getUsername())
					.password(properties.getPassword())
					.build();
		return db;
	}

}
