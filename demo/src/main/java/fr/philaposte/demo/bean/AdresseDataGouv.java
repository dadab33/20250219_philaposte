package fr.philaposte.demo.bean;

import java.util.List;

public class AdresseDataGouv {
	
	private String type;
	private String version;
	private List<Feature> features;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public List<Feature> getFeatures() {
		return features;
	}
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
}
