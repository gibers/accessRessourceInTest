package com.example.bern.accessRessourceInTest.springBootTest;

import com.example.bern.accessRessourceInTest.dtos.PersonDTO;
import com.example.bern.accessRessourceInTest.entities.PersonsEntity;
import com.example.bern.accessRessourceInTest.repositories.PersonsRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.jackson.JsonNodeValueReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest(properties = "applicationTest.yml")
@SpringBootTest
//@TestPropertySource(locations = "/applicationTest.yml")
@AutoConfigureDataJpa
//@EnableJpaRepositories
//@EntityScan("com.example.bern.accessRessourceInTest.entities")
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
@Sql({"/insert_persons.sql"})
class SpringBootTestClasse {

	private final Logger logger = Logger.getLogger(SpringBootTestClasse.class.getName());

	private static ModelMapper modelMapper = new ModelMapper();

	@Value("${spring.application.name}")
	String name;

	@Value("${prenom}")
	String prenom;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	PersonsRepository personsRepository;

	@BeforeAll
	static void setUp() {
		modelMapper.getConfiguration().addValueReader(new JsonNodeValueReader());
	}

	@Test
	void contextLoads() {
		System.out.println( String.format(" test contextLoads => %s %s ", name, prenom) );
		List<PersonsEntity> all = personsRepository.findAll();
		logger.log(Level.INFO, String.format(" all %s ", all));
		all.forEach(x -> logger.log(Level.INFO, String.format(" persons => %s ", x.getEmail())));
	}

	@Test
	void callEndpointGetCar() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/car/toto"))
				.andDo(print())
				.andExpect(status().isOk());
		// THEN
		MvcResult mvcResult = resultActions.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		String contentAsString = response.getContentAsString();
		logger.info(contentAsString);

		JsonNode orderNode = new ObjectMapper().readTree(contentAsString);
		PersonDTO map = modelMapper.map(orderNode, PersonDTO.class);

		Assertions.assertEquals("bertrand", map.getName());
		Assertions.assertEquals("Jean-Louis", map.getVorname());

	}


}
