package fr.philaposte.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.philaposte.formation.bean.ordinateur.OrdinateurInput;
import fr.philaposte.formation.bean.ordinateur.OrdinateurOutput;
import fr.philaposte.formation.exception.AddOrdiEmptyParamException;
import fr.philaposte.formation.exception.AddOrdiException;
import fr.philaposte.formation.exception.DeleteOrdiException;
import fr.philaposte.formation.exception.GetOrdiException;
import fr.philaposte.formation.exception.OrdiNotFoundException;
import fr.philaposte.formation.exception.PutOrdiException;
import fr.philaposte.formation.service.OrdinateurService;

@RestController
@RequestMapping("/ordinateur")
public class OrdinateurController {

	@Autowired
	private OrdinateurService ordinateurService;
	
	@PostMapping
	public OrdinateurOutput addOrdinateur(@RequestBody(required = false) OrdinateurInput ordi) throws AddOrdiException, AddOrdiEmptyParamException {
		if(ordi == null) {
			throw new AddOrdiEmptyParamException(null);
		}
		
		return ordinateurService.addOrdi(ordi);
	}
	
	@GetMapping("/{id}")
	public OrdinateurOutput getOrdinateur(@PathVariable String id) throws GetOrdiException, OrdiNotFoundException {
		return ordinateurService.getOrdi(id);
	}
	
	@PutMapping("/{id}")
	public OrdinateurOutput updateOrdinateur(@PathVariable String id, @RequestBody OrdinateurInput ordi) throws PutOrdiException {
		return ordinateurService.updateOrdi(id, ordi);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrdinateur(@PathVariable String id) throws DeleteOrdiException {
		ordinateurService.deleteOrdi(id);
	}
}
