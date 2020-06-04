package com.api.geopet.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.geopet.json.Animal;
import com.api.geopet.model.AnimalEntity;
import com.api.geopet.service.AnimalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Animals")
@RestController
@RequestMapping("/animals")
public class AnimalController {

	@Autowired
	AnimalService service;

	@DeleteMapping(value = "/{id}")
	@ApiOperation("Delete animal by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found") })
	public void deleteAnimal(@PathVariable("id") final Long id) {
		this.service.deleteAnimalById(id);
	}

	@GetMapping
	@ApiOperation("Find all animals")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found") })
	public List<AnimalEntity> findAllAnimals() {
		return this.service.findAllAnimals();
	}

	@GetMapping(value = "/{id}")
	@ApiOperation("Find animal by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found") })
	public AnimalEntity findAnimalById(@PathVariable("id") final Long id) {
		return this.service.findAnimalById(id);
	}

	@PostMapping
	@ApiOperation("Save animal")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Animal successfuly reported") })
	public Animal saveAnimal(@RequestBody Animal animal) {
		return this.service.saveAnimal(animal);
	}

	@PutMapping(value = "/{id}")
	@ApiOperation("Update animal")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found") })
	public Animal updateAnimal(@PathVariable("id") final Long id, @RequestBody Animal animal) {
		return this.service.updateAnimal(animal, id);
	}

}
