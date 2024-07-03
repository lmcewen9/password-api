package com.lukemcewen.PasswordApi;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class PasswordApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PasswordApiApplication.class, args);
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
