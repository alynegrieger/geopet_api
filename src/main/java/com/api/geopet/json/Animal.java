package com.api.geopet.json;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.api.geopet.enums.AnimalSpecies;
import com.api.geopet.enums.Situation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class Animal implements Serializable {

	private static final long serialVersionUID = -8151121028893235766L;

	private LocalDateTime date;

	@NotEmpty(message = "{description.not.empty}")
	private String description;

	private Long id;

	@NotNull
	private Location location;

	@NotNull
	private AnimalSpecies species;

	@NotNull
	private Situation status;

	private byte[] image;

}
