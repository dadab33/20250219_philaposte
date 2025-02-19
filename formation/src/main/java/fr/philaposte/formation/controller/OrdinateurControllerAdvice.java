package fr.philaposte.formation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.philaposte.formation.bean.ApiError;
import fr.philaposte.formation.exception.AddOrdiException;
import fr.philaposte.formation.exception.DeleteOrdiException;
import fr.philaposte.formation.exception.GetOrdiException;
import fr.philaposte.formation.exception.OrdiNotFoundException;
import fr.philaposte.formation.exception.PutOrdiException;
import fr.philaposte.formation.exception.SearchAdresseDataGouvException;
import fr.philaposte.formation.exception.SearchAdresseDataGouvParamEmptyException;

@RestControllerAdvice
public class OrdinateurControllerAdvice {

	@ExceptionHandler(AddOrdiException.class)
	public ResponseEntity<ApiError> onAddOrdiException() {
		return new ResponseEntity<ApiError>(new ApiError("003", "Une erreur est survenue durant l'ajout d'un ordi"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(GetOrdiException.class)
	public ResponseEntity<ApiError> onGetOrdiException() {
		return new ResponseEntity<ApiError>(new ApiError("004", "Une erreur est survenue durant la récupération d'un ordi"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PutOrdiException.class)
	public ResponseEntity<ApiError> onPutOrdiException() {
		return new ResponseEntity<ApiError>(new ApiError("005", "Une erreur est survenue durant la MAJ d'un ordi"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DeleteOrdiException.class)
	public ResponseEntity<ApiError> onDeleteOrdiException() {
		return new ResponseEntity<ApiError>(new ApiError("006", "Une erreur est survenue durant la suppression d'un ordi"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrdiNotFoundException.class)
	public ResponseEntity<ApiError> onOrdiNotFoundException() {
		return new ResponseEntity<ApiError>(new ApiError("007", "Ressource non trouvée"), HttpStatus.NOT_FOUND);
	}
}
