package fr.philaposte.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.philaposte.demo.bean.Ordinateur;
import fr.philaposte.demo.exception.AddOrdiException;
import fr.philaposte.demo.exception.GetOrdiException;
import fr.philaposte.demo.exception.UpdateOrdiException;

@Service
public class OrdinateurService {

	@Autowired
	private RestTemplate restTemplate;
	
	public String addOrdinateur(Ordinateur ordi) throws AddOrdiException {
		var response = restTemplate.postForEntity("https://api.restful-api.dev/objects", ordi, Ordinateur.class);
		
		if(response.getStatusCode().is2xxSuccessful()) {
			return response.getBody().getId();
		} else {
			throw new AddOrdiException(null);
		}
	}
	
	public Ordinateur updateOrdinateur(Ordinateur ordi) throws AddOrdiException, UpdateOrdiException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

		var response = restTemplate.exchange("https://api.restful-api.dev/objects/" + ordi.getId(), HttpMethod.PUT, new HttpEntity<>(ordi, headers), Ordinateur.class);
		
		if(response.getStatusCode().is2xxSuccessful()) {
			return response.getBody();
		} else {
			throw new UpdateOrdiException(null);
		}
	}
	
	public Ordinateur getordinateur(String id) throws GetOrdiException {
		var response = restTemplate.getForEntity("https://api.restful-api.dev/objects/" + id, Ordinateur.class);
		
		if(response.getStatusCode().is2xxSuccessful()) {
			return response.getBody();
		} else {
			throw new GetOrdiException(null);
		}
	}
}
