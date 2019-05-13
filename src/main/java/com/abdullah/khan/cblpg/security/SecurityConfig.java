package com.abdullah.khan.cblpg.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
				.withUser("user1").password("secret1").roles("USER").and().withUser("admin1").password("secret1")
				.roles("USER", "ADMIN");
	}

	// Authorization : Role -> Access
	// survey -> USER
	protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic()
			.and()
			.authorizeRequests()
			//.antMatchers("/orderui/**") .permitAll()
			.antMatchers("/orders/**") .permitAll()
			.antMatchers("/cancel/**") .permitAll()
			.antMatchers("/approve/**") .permitAll()
			.antMatchers("/decline/**") .permitAll()
		
			//.antMatchers("/orderuiencode/**") .permitAll()
			.antMatchers("/surveys/**").hasRole("USER")
			.antMatchers("/users/**").hasRole("USER")
			//.antMatchers("/orders/**").hasRole("USER")
			.antMatchers("/**").hasRole("ADMIN")
			
			.and()
			.csrf()
			.disable()
			.headers()
			.frameOptions()
			.disable()
			;
			
	}
}
