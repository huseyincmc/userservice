package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

  @Bean
  CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"Huseyin Camci","huseyin","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Will Smith","will","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Jim Carry","jim","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Sylvester Stallone","sylvester","1234",new ArrayList<>()));

			userService.addRoleToUser("huseyin","ROLE_USER");
			userService.addRoleToUser("huseyin","ROLE_MANAGER");
			userService.addRoleToUser("will","ROLE_MANAGER");
			userService.addRoleToUser("jim","ROLE_USER");
			userService.addRoleToUser("sylvester","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("sylvester","ROLE_ADMIN");
			userService.addRoleToUser("sylvester","ROLE_USER");

		};

  }

}
