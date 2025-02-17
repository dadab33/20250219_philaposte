package fr.philaposte.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import fr.philaposte.demo.bean.ApiError;
import fr.philaposte.demo.exception.AddOrdiException;
import fr.philaposte.demo.exception.AdresseInputMissingException;
import fr.philaposte.demo.exception.GetOrdiException;
import fr.philaposte.demo.exception.UpdateOrdiException;

@ControllerAdvice
public class TestControllerAdvice {

	@ExceptionHandler(AdresseInputMissingException.class)
    public ResponseEntity<Object> handleAdresseInputMissingException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError("00001", "L'adresse renseignée en input est nulle"), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(AddOrdiException.class)
    public ResponseEntity<Object> handleAddOrdiException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError("00002", "L'ajout d'un ordi dans l'API a echoué"), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(GetOrdiException.class)
    public ResponseEntity<Object> handleGetOrdiException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError("00003", "La récup d'un ordi dans l'API a echoué"), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(UpdateOrdiException.class)
    public ResponseEntity<Object> handleUpdateOrdiException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError("00004", "La modif d'un ordi dans l'API a echoué"), HttpStatus.BAD_REQUEST);
    }
}
