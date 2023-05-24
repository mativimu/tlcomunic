package com.tlcomunic.aut;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.tlcomunic.aut.domain.User;
import com.tlcomunic.aut.enums.Role;
import com.tlcomunic.aut.repository.UserRepository;
import com.tlcomunic.aut.security.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class AutApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			userRepository.save (
				new User (
					null,
					"Matias",
					"Vigo",
					"mativimu.dev@gmail.com",
					"d7f3fa33e69a29d562d36f95b5a990a6bf4db44ceb2dc70b7bb0750f552b45dc",
					true,
					Role.ADMIN,
					true,
					true,
					true,
					new Date(),
					new Date()
				)
			);
		};
	}
}