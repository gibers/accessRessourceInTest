package com.example.bern.accessRessourceInTest.dtos;

public class PersonDTO {

    private Long idPersons;

    private String vorname;
    private String name;
    private String email;

    public Long getIdPersons() {
        return idPersons;
    }

    public void setIdPersons(Long idPersons) {
        this.idPersons = idPersons;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
