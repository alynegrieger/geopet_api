package com.api.geopet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.geopet.json.Animal;
import com.api.geopet.model.AnimalEntity;
import com.api.geopet.repository.AnimalRepository;
import com.api.geopet.repository.AnimalRepositorySpec;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	AnimalRepository repository;

	@Autowired
	AnimalRepositorySpec repositorySpec;

	@Override
	public Animal saveAnimal(Animal animal) {
		AnimalEntity entity = new AnimalEntity();
		BeanUtils.copyProperties(animal, entity);
		BeanUtils.copyProperties(animal.getLocation(), entity);
		this.repository.save(entity);
		animal.setId(entity.getId());
		return animal;
	}

	@Override
	public List<AnimalEntity> findAllAnimals() {
		return this.repository.findAll();
	}

	@Override
	public AnimalEntity findAnimalById(Long id) {
		return repositorySpec.findAnimalById(id);
	}

	@Override
	public void deleteAnimalById(Long id) {
		this.repository.deleteById(id);

	}

	@Override
	public Animal updateAnimal(Animal animal, Long id) {
		AnimalEntity animalEntity = this.repositorySpec.findAnimalById(id);
		BeanUtils.copyProperties(animal, animalEntity);
		this.repository.save(animalEntity);
		BeanUtils.copyProperties(animalEntity, animal);
		return animal;

	}

}
