package fr.philaposte.demo.bean;

public class ApiError {
	private String code;
	private String libelle;
	
	public ApiError(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
