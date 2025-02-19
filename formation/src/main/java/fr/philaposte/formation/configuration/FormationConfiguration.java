package fr.philaposte.formation.configuration;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FormationConfiguration {
//	@Bean
//	public SecurityFilterChain securityWebFilterFilterChain(HttpSecurity http) throws Exception {
//		return http.
//				authorizeHttpRequests(auth -> auth.requestMatchers("/**").
//						permitAll()).
//				build();
//	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.
				connectTimeout(Duration.ofSeconds(5)).
				readTimeout(Duration.ofSeconds(5)).
				build();
	}
}
