package fr.philaposte.formation.bean.ordinateur;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdinateurOutput {
	private String id;
	private String name;
	private Data data;
	
	@JsonProperty("createdAt")
	private String dateCreation;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
}
