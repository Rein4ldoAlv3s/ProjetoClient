package com.reinaldo.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;



@EnableWebSecurity
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	// Configura o que está sendo protegido pelo protocolo HTTP
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// para proteger tudo
		http.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		log.info("Password encoder {} ", passwordEncoder.encode("teste"));
		auth.inMemoryAuthentication()
		.withUser("william")
		.password(passwordEncoder.encode("academy"))
		.roles("USER","ADMIN")
		.and()
		.withUser("devdojo")
		.password(passwordEncoder.encode("academy"))
		.roles("USER");

	}

}
