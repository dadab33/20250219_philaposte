package fr.philaposte.formation.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public String hello(String nom) {
		return "Hello : " + nom;
	}
	
	public String coucou(String nom) {
		return "Coucou : " + nom;
	}
}
