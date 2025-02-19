package fr.philaposte.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.philaposte.formation.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping("/gilles")
	public String test() {
		return testService.hello("Gilles");
	}
	
	@GetMapping("/alexis/{id}")
	public String alexis(@PathVariable String id, @RequestParam(required = false, name = "query", defaultValue = "") String toto) {
		return testService.coucou("Alexis : " + id + " / " + toto);
	}
}