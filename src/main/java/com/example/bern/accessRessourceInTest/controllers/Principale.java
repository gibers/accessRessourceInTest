package com.example.bern.accessRessourceInTest.controllers;

import com.example.bern.accessRessourceInTest.dtos.PersonDTO;
import com.example.bern.accessRessourceInTest.entities.PersonsEntity;
import com.example.bern.accessRessourceInTest.repositories.PersonsRepository;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class Principale {

    private final Logger logger = Logger.getLogger(Principale.class.getName());

    private final PersonsRepository personsRepository;

//    @Autowired
    public Principale(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @GetMapping(value = "car/{marque}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO getCar(@PathVariable String marque, @RequestParam @Nullable String velo) {
        logger.log(Level.INFO, String.format(" appel de car: %s %s %s ", marque, velo, personsRepository.findAll().size()));
        var pers = new PersonDTO();
        pers.setName("bertrand");
        pers.setVorname("Jean-Louis");
        return pers;
    }

    @PostMapping(value = "person/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void pCar(@RequestBody PersonDTO person) {
        String s = ToStringBuilder.reflectionToString(person, ToStringStyle.MULTI_LINE_STYLE);
        List<PersonsEntity> allPerson = personsRepository.findAll();
        logger.log(Level.INFO, String.format(" toutes les personnes: %s ", allPerson.size()));

        var map = new ModelMapper();
        PersonsEntity map1 = map.map(person, PersonsEntity.class);
        logger.log(Level.INFO, String.format(" appel de car: %s ", ToStringBuilder.reflectionToString(map1, ToStringStyle.MULTI_LINE_STYLE)));
        personsRepository.save(map1);

    }

}
