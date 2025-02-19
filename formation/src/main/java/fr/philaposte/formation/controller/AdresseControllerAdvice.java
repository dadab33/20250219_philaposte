package fr.philaposte.formation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.philaposte.formation.bean.ApiError;
import fr.philaposte.formation.exception.SearchAdresseDataGouvException;
import fr.philaposte.formation.exception.SearchAdresseDataGouvParamEmptyException;

@RestControllerAdvice
public class AdresseControllerAdvice {

	@ExceptionHandler(SearchAdresseDataGouvException.class)
	public ResponseEntity<ApiError> onSearchAdresseDataGouvException() {
		return new ResponseEntity<ApiError>(new ApiError("001", "Une erreur est survenue durant l'appel à l'API Data Gouv"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SearchAdresseDataGouvParamEmptyException.class)
	public ResponseEntity<ApiError> onSearchAdresseDataGouvParamEmptyException() {
		return new ResponseEntity<ApiError>(new ApiError("002", "La paramètre d'entrée est invalide"), HttpStatus.BAD_REQUEST);
	}
}
