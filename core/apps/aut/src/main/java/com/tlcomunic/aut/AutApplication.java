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
					"mati",
					"vimu",
					"mativimu@gmail.com",
					"e6808a56aad66cf89b43388ef3d0f021206594399dcd6c1b70d8382a1dae402b",
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