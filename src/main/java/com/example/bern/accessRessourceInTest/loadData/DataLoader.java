package com.example.bern.accessRessourceInTest.loadData;

import com.example.bern.accessRessourceInTest.controllers.Principale;
import com.example.bern.accessRessourceInTest.entities.PersonsEntity;
import com.example.bern.accessRessourceInTest.repositories.PersonsRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Profile({"test"})
public class DataLoader {

    private final Logger logger = Logger.getLogger(DataLoader.class.getName());

    private PersonsRepository personsRepository;

    DataLoader(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @PostConstruct
    public void executeInsert() {
        logger.log(Level.INFO,String.format(" appel de executeInsert: "));

        var persons1 = new PersonsEntity();
        persons1.setEmail("toto@gmail.com");
        persons1.setName("Jacob");
        persons1.setVorname("Simon");

        var persons2 = new PersonsEntity();
        persons2.setEmail("jj@gmail.com");
        persons2.setName("Mickal");
        persons2.setVorname("Jordan");

        this.personsRepository.save(persons1);
        this.personsRepository.save(persons2);
    }

}
