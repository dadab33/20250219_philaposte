package fr.philaposte.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.philaposte.demo.service.TestService;

@RestController
@RequestMapping(path = "/api")
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping(path = "/hello")
	public String hello() {
		return testService.getMessage("Hello !");
	}
	
	@GetMapping(path = "/coucou/{nom}")
	public String coucou(
			@PathVariable String nom, 
			@RequestParam(required = false) String prenom) {
		return testService.getMessage("Coucou Monsieur ou Madame : " + nom + " " + prenom);
	}
}
