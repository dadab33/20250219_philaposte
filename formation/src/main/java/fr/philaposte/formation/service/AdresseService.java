package fr.philaposte.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import fr.philaposte.formation.bean.adresse.AdresseDataGouv;
import fr.philaposte.formation.exception.SearchAdresseDataGouvException;
import fr.philaposte.formation.exception.SearchAdresseDataGouvParamEmptyException;
import io.micrometer.common.util.StringUtils;

@Service
public class AdresseService {

	@Autowired
	private RestTemplate restTemplate;
	
	public AdresseDataGouv search(String queryAdr) throws SearchAdresseDataGouvException, SearchAdresseDataGouvParamEmptyException {
		if(StringUtils.isNotEmpty(queryAdr)) {
			try {
				ResponseEntity<AdresseDataGouv> reponse = restTemplate.getForEntity("https://api-adresse.data.gouv.fr/search/?q=" + queryAdr + "&limit=15", AdresseDataGouv.class);
				
				if(reponse.getStatusCode().is2xxSuccessful()) {
					return reponse.getBody();
				} else {
					throw new SearchAdresseDataGouvException(reponse.toString());
				}				
			} catch (HttpClientErrorException e) {
				throw new SearchAdresseDataGouvException(e.getMessage());
			}
		} else {
			throw new SearchAdresseDataGouvParamEmptyException(null);
		}
	}
}
