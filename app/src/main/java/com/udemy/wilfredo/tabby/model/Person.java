package com.udemy.wilfredo.tabby.model;

/**
 * Clase que representa a una persona en la aplicación
 * Created by wilfredo on 24-02-18.
 */

public class Person {

    private String personName;
    private Country personCountry;

    public Person(String personName, Country personCountry) {
        this.personName = personName;
        this.personCountry = personCountry;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Country getPersonCountry() {
        return personCountry;
    }

    public void setPersonCountry(Country personCountry) {
        this.personCountry = personCountry;
    }
}
