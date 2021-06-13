package com.example.bern.accessRessourceInTest.controllers;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class Principale {

    private final Logger logger = Logger.getLogger(Principale.class.getName());

    @GetMapping(value = "car/{marque}")
    public void getCar(@PathVariable String marque, @RequestParam @Nullable String velo ) {
        logger.log(Level.INFO, String.format(" appel de car: %s %s ", marque, velo));
    }


}
