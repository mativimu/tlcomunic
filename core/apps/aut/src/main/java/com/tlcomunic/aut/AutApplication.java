package com.tlcomunic.aut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.tlcomunic.aut.security.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class AutApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutApplication.class, args);
	}
}