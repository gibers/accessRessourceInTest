package com.example.bern.accessRessourceInTest.repositories;

import com.example.bern.accessRessourceInTest.entities.PersonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<PersonsEntity, Long> {



}

