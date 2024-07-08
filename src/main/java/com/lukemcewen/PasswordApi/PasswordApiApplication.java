package com.lukemcewen.PasswordApi;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.Bean;

//import com.lukemcewen.PasswordApi.repository.Password;
//import com.lukemcewen.PasswordApi.repository.PasswordRepository;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class PasswordApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PasswordApiApplication.class, args);
	}

	/*@Autowired
	PasswordRepository passwordRepository;

	@Bean
	@ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
	public CommandLineRunner commandLineRunner(){
		return args ->{
			System.out.println("Running...");

			Password p1 = new Password("PeacockTv", null, "lukemhockey@gmail.com", "password1");
			Password p2 = new Password("github", "lmcewen9", "lukemhockey@gmail.com", "password2");
			Password p3 = new Password("poopass", "aidsbogger", "luke@lukemcewen.com", "password3");
			Password p4 = new Password("Netflix", null, "blalik@twcny.rr.com", "password4");

			passwordRepository.saveAll(List.of(p1, p2, p3, p4));
		};
	}*/

}
