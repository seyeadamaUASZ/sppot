package com.sppot.sid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@SpringBootApplication
public class SppotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SppotApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getPBCE() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

}
