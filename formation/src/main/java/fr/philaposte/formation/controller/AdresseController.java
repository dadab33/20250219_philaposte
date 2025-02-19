package fr.philaposte.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.philaposte.formation.bean.adresse.AdresseDataGouv;
import fr.philaposte.formation.exception.SearchAdresseDataGouvException;
import fr.philaposte.formation.exception.SearchAdresseDataGouvParamEmptyException;
import fr.philaposte.formation.service.AdresseService;

@RestController
@RequestMapping("/adresse")
public class AdresseController {

	@Autowired
	private AdresseService adresseService;
	
	@GetMapping
	public AdresseDataGouv search(@RequestParam(required = false) String queryAdr) throws SearchAdresseDataGouvException, SearchAdresseDataGouvParamEmptyException {
		return adresseService.search(queryAdr);
	}
}
