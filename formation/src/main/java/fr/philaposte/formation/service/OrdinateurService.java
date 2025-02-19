package fr.philaposte.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import fr.philaposte.formation.bean.ordinateur.OrdinateurInput;
import fr.philaposte.formation.bean.ordinateur.OrdinateurOutput;
import fr.philaposte.formation.exception.AddOrdiException;
import fr.philaposte.formation.exception.DeleteOrdiException;
import fr.philaposte.formation.exception.GetOrdiException;
import fr.philaposte.formation.exception.OrdiNotFoundException;
import fr.philaposte.formation.exception.PutOrdiException;

@Service
public class OrdinateurService {

	@Autowired
	private RestTemplate restTemplate;
	
	public OrdinateurOutput addOrdi(OrdinateurInput ordi) throws AddOrdiException {
		var reponse = restTemplate.postForEntity("https://api.restful-api.dev/objects", ordi, OrdinateurOutput.class);
		
		if(reponse.getStatusCode().is2xxSuccessful()) {
			return reponse.getBody();
		} else {
			throw new AddOrdiException(null);
		}
	}
	
	public OrdinateurOutput getOrdi(String id) throws GetOrdiException, OrdiNotFoundException {
		try {
			var reponse = restTemplate.getForEntity("https://api.restful-api.dev/objects/" + id, OrdinateurOutput.class);
			
			if(reponse.getStatusCode().is2xxSuccessful()) {
				return reponse.getBody();
			} else {
				throw new GetOrdiException(null);
			}
		} catch (HttpClientErrorException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new OrdiNotFoundException();
			} else {
				throw new GetOrdiException(e.getMessage());				
			}
		}
	}
	
	public OrdinateurOutput updateOrdi(String id, OrdinateurInput ordi) throws PutOrdiException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		var reponse = restTemplate.exchange(
				"https://api.restful-api.dev/objects/" + id, 
				HttpMethod.PUT, 
				new HttpEntity<>(ordi, headers),
				OrdinateurOutput.class);
		
		if(reponse.getStatusCode().is2xxSuccessful()) {
			return reponse.getBody();
		} else {
			throw new PutOrdiException(null);
		}
	}
	
	public void deleteOrdi(String id) throws DeleteOrdiException {
		try {
			restTemplate.delete("https://api.restful-api.dev/objects/" + id);
		} catch (RestClientException e) {
			throw new DeleteOrdiException(e.getMessage());
		}
	}
}
