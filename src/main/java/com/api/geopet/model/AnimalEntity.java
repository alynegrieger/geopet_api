package com.api.geopet.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.api.geopet.enums.AnimalSpecies;
import com.api.geopet.enums.Situation;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "animal")
@Getter
@Setter
public class AnimalEntity {

	@Column(name = "date")
	private LocalDateTime date;

	@Column(name = "description")
	private String description;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "lat")
	private String lat;

	@Column(name = "lng")
	private String lng;

	@Column(name = "species")
	private AnimalSpecies species;

	@Column(name = "situation")
	private Situation status;

	@Column(name = "image")
	@Lob
	private byte[] image;

	@Column(name = "inclusionDate")
	private LocalDateTime InclusionDate;

	@Column(name = "changeDate")
	private LocalDateTime changeDate;

	@PrePersist
	private void beforePersist() {
		final LocalDateTime atualDate = LocalDateTime.now();
		this.InclusionDate = atualDate;
		this.changeDate = atualDate;
	}

	@PreUpdate
	private void beforeUpdate() {
		final LocalDateTime atualDate = LocalDateTime.now();
		this.changeDate = atualDate;
	}

}
