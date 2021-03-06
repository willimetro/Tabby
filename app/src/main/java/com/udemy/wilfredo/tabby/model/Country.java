package com.udemy.wilfredo.tabby.model;

/**
 * Clase que representa un país en la aplicación
 * Created by wilfredo on 24-02-18.
 */

public class Country {

    private String countryName;
    private String countryCode;

    public Country(String countryName, String countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFlagURL() {
        return "http://www.geognos.com/api/en/countries/flag/"+countryCode+".png";
    }

    /**
     * Se sobreescribe el método toString para mostrar los nombres de los paises en el spinner
     * @return {@link String} con el nombre del pais
     */
    @Override
    public String toString() {
        return countryName;
    }
}
