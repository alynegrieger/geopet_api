package com.api.geopet.json;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.api.geopet.enums.AnimalSpecies;
import com.api.geopet.enums.Situation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sun.istack.NotNull;

@JsonInclude(Include.NON_NULL)
public class Animal implements Serializable {

	
	private static final long serialVersionUID = -8151121028893235766L;


	private LocalDateTime date;
	
	
	@NotNull
	private String description;
	
	private Long id;
	
	@NotNull
	private Location location;
	
	private AnimalSpecies species;
	
	@NotNull
	private Situation status;

	public LocalDateTime getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public Location getLocation() {
		return location;
	}

	public AnimalSpecies getSpecies() {
		return species;
	}

	public Situation getStatus() {
		return status;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setSpecies(AnimalSpecies species) {
		this.species = species;
	}

	public void setStatus(Situation status) {
		this.status = status;
	}
	
	
	
	
	
	
	
}
