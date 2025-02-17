package fr.philaposte.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.philaposte.demo.bean.Ordinateur;
import fr.philaposte.demo.exception.AddOrdiException;
import fr.philaposte.demo.exception.GetOrdiException;
import fr.philaposte.demo.exception.UpdateOrdiException;
import fr.philaposte.demo.service.OrdinateurService;

@RestController
@RequestMapping("/api")
public class OrdinateurController {

	@Autowired
	private OrdinateurService ordinateurService;
	
	@PostMapping("/ordinateur")
	public String addOrdinateur(@RequestBody Ordinateur ordinateur) throws AddOrdiException {
		return ordinateurService.addOrdinateur(ordinateur);
	}
	
	@PutMapping("/ordinateur/{id}")
	public Ordinateur updateOrdinateur(@PathVariable String id, @RequestBody Ordinateur ordinateur) throws AddOrdiException, UpdateOrdiException {
		ordinateur.setId(id);
		return ordinateurService.updateOrdinateur(ordinateur);
	}

	@GetMapping("/ordinateur/{id}")
	public Ordinateur getOrdinateur(@PathVariable String id) throws GetOrdiException {
		return ordinateurService.getordinateur(id);
	}
}
