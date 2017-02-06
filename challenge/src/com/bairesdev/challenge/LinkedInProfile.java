package com.bairesdev.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LinkedInProfile implements Comparable<LinkedInProfile> {
	private String publicProfileURL;
	private String name;
	private String lastName;
	private String title;
	private String geographicArea;
	private String numberOfRecommendations;
	private String numberOfConnections;
	private String currentRole;
	private String industry;
	private String country;
	
	public String getPublicProfileURL() {
		return publicProfileURL;
	}
	public void setPublicProfileURL(String publicProfileURL) {
		this.publicProfileURL = publicProfileURL;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGeographicArea() {
		return geographicArea;
	}
	public void setGeographicArea(String geographicArea) {
		this.geographicArea = geographicArea;
	}
	public String getNumberOfRecommendations() {
		return numberOfRecommendations;
	}
	public void setNumberOfRecommendations(String numberOfRecommendations) {
		this.numberOfRecommendations = numberOfRecommendations;
	}
	public String getNumberOfConnections() {
		return numberOfConnections;
	}
	public void setNumberOfConnections(String numberOfConnections) {
		this.numberOfConnections = numberOfConnections;
	}
	public String getCurrentRole() {
		return currentRole;
	}
	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public List<Consumer<String>> getSetters() {
		return Arrays.asList(
				this::setPublicProfileURL,
				this::setName,
				this::setLastName,
				this::setTitle,
				this::setGeographicArea,
				this::setNumberOfRecommendations,
				this::setNumberOfConnections,
				this::setCurrentRole,
				this::setIndustry,
				this::setCountry);
	}
	@Override
	public int compareTo(LinkedInProfile o) {
		return Integer.compare(ProfileRanker.INSTANCE.rank(o), ProfileRanker.INSTANCE.rank(this));
	}
	
	@Override
	public String toString() {
		return String.format("Fullname: %s %s - Title: %s - From: %s", name.trim(), lastName.trim(), title.trim(), country.trim());
	}
}
