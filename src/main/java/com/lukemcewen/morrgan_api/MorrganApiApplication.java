package com.lukemcewen.morrgan_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.lukemcewen.morrgan_api.model.Song;
import com.lukemcewen.morrgan_api.model.SongRepository;

@SpringBootApplication
public class MorrganApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MorrganApiApplication.class, args);
	}

	@Autowired
	SongRepository songRepository;

	@Bean
	@ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
	public CommandLineRunner commandLineRunner(){
		return args -> {
			Song s1 = new Song("Love Sosa", "Chief Keef");
			Song s2 = new Song("No Flockin", "Kodak Black");
			Song s3 = new Song("Tunnel Vision", "Kodak Black");
			Song s4 = new Song("Piano Man", "Billy Joel");

			songRepository.saveAll(List.of(s1, s2, s3, s4));
		};
	}

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MorrganApiApplication.class);
	}*/

}
