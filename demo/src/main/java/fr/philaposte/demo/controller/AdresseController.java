package fr.philaposte.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.philaposte.demo.bean.AdresseDataGouv;
import fr.philaposte.demo.exception.AdresseInputMissingException;
import fr.philaposte.demo.exception.GetAdresseDataGouvException;
import fr.philaposte.demo.service.TestService;

@RestController
@RequestMapping("/api")
public class AdresseController {

	@Autowired
	private TestService testService;
	
	@GetMapping("/adresse")
	public AdresseDataGouv getAdresse(@RequestParam(required = false) String adresse) throws AdresseInputMissingException, GetAdresseDataGouvException {
		
		if(ObjectUtils.isEmpty(adresse)) {
			throw new AdresseInputMissingException();
		}
		
		return testService.getAdresses(adresse);
	}
}
