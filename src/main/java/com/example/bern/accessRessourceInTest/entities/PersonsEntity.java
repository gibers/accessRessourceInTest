package com.example.bern.accessRessourceInTest.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "persons", schema = "public", catalog = "testaccessresources")
public class PersonsEntity {
    private long idPersons;
    private String vorname;
    private String name;
    private String email;

    @Id
    @Column(name = "id_persons", nullable = false)
    public long getIdPersons() {
        return idPersons;
    }

    public void setIdPersons(long idPersons) {
        this.idPersons = idPersons;
    }

    @Basic
    @Column(name = "vorname", nullable = true, length = -1)
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = false, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonsEntity that = (PersonsEntity) o;
        return idPersons == that.idPersons && Objects.equals(vorname, that.vorname) && Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersons, vorname, name, email);
    }
}
