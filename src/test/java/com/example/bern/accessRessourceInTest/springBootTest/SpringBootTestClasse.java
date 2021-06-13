package com.example.bern.accessRessourceInTest.springBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

//@SpringBootTest(properties = "applicationTest.yml")
@SpringBootTest
//@TestPropertySource(locations = "/applicationTest.yml")
@AutoConfigureDataJpa
@ActiveProfiles(value = "test")
class SpringBootTestClasse {

	@Value("${spring.application.name}")
	String name;

	@Value("${prenom}")
	String prenom;

	@Test
	void contextLoads() {
		System.out.println( String.format(" test contextLoads => %s %s ", name, prenom) );
	}

}
