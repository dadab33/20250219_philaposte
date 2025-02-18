package fr.philaposte.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
	    return http
	      .authorizeHttpRequests(auth -> auth
	        .requestMatchers("/actuator/**").permitAll()
	        .anyRequest().authenticated())
	      .build();
	}
}