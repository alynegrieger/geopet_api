package com.api.geopet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public ResponseEntity<?> deleteAnimal(@PathVariable("id") final Long id) {
		this.service.deleteAnimalById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
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
	public ResponseEntity<Animal> saveAnimal(@Valid @RequestBody Animal animal) {
		Animal resposta = this.service.saveAnimal(animal);
		return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
	}

	@PutMapping(value = "/{id}")
	@ApiOperation("Update animal")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found") })
	public Animal updateAnimal(@PathVariable("id") final Long id, @Valid @RequestBody Animal animal) {
		return this.service.updateAnimal(animal, id);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
