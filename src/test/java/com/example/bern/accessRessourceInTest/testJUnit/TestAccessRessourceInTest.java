package com.example.bern.accessRessourceInTest.testJUnit;

import com.example.bern.accessRessourceInTest.Configurations.Config1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = Config1.class)
public class TestAccessRessourceInTest {

    @Autowired
    String version;

    @Test
    void test1 () {
        System.out.println(" version => " + version);
    }

}
