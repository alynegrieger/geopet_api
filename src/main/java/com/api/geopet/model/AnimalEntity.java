package com.api.geopet.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.api.geopet.enums.AnimalSpecies;
import com.api.geopet.enums.Situation;
import com.api.geopet.json.Location;

@Entity
@Table(name = "animal") 
public class AnimalEntity {

	@Column(name = "date")
	private LocalDateTime date;

	@Column(name = "description")
	private String description;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "lat")
	private Integer lat;

	@Column(name = "lng")
	private Integer lng;

	@Column(name = "species")
	private AnimalSpecies species;

	@Column(name = "situation")
	private Situation status;

	public Integer getLat() {
		return lat;
	}

	public void setLat(Integer lat) {
		this.lat = lat;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public Integer getLng() {
		return lng;
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

	public void setLng(Integer lng) {
		this.lng = lng;
	}

	public void setSpecies(AnimalSpecies species) {
		this.species = species;
	}

	public void setStatus(Situation status) {
		this.status = status;
	}

}
