package com.api.geopet.service;

import java.util.List;
import java.util.Optional;

import com.api.geopet.json.Animal;
import com.api.geopet.model.AnimalEntity;

public interface AnimalService {

	
	List<AnimalEntity> findAllAnimals();

	Animal saveAnimal(Animal animal);

	AnimalEntity findAnimalById(Long id);

	void deleteAnimalById(Long id);
	
	Animal updateAnimal(Animal animal, Long id);
	
}
