package com.api.geopet.repository;



import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.geopet.config.exception.AnimalNotFoundException;
import com.api.geopet.model.AnimalEntity;

@Repository
public class AnimalRepositorySpec {

	@Autowired
	EntityManager entityManager;

	public AnimalEntity findAnimalById(Long id) {
		try {
			final String jpql = "FROM AnimalEntity WHERE id = :id";
			final TypedQuery<AnimalEntity> query = this.entityManager.createQuery(jpql, AnimalEntity.class);

			query.setParameter("id", id);
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new AnimalNotFoundException("Id: " + id.toString());
		}catch(NonUniqueResultException e) {
			throw new NonUniqueResultException("Foram encontrados mais de um registro");
		}
	}

}
