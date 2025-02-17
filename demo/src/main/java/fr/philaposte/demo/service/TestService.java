package fr.philaposte.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.philaposte.demo.bean.AdresseDataGouv;
import fr.philaposte.demo.exception.GetAdresseDataGouvException;

@Service
public class TestService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getMessage(String message) {
		return "Message depuis le service : " + message;
	}
	
	public AdresseDataGouv getAdresses(String adresse) throws GetAdresseDataGouvException {
		var response = restTemplate.getForEntity("https://api-adresse.data.gouv.fr/search/?q=" + adresse + "&limit=15", AdresseDataGouv.class);
		
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new GetAdresseDataGouvException("Erreur lors de l'appel à l'API : " + response.getStatusCode());
        }
    }
}
