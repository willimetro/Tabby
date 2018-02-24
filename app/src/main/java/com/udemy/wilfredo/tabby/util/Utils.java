package com.udemy.wilfredo.tabby.util;

import com.udemy.wilfredo.tabby.model.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase util, encarga de realizar distintas tareas
 * Created by wilfredo on 24-02-18.
 */

public class Utils {

    /**
     * Método que crea el listado de paises a mostrar en el spinner y a asociar a la persona
     * @return {@link List} con los paises a mostrar en el spinner
     */
    public static List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("España", "ES"));
        countries.add(new Country("Argentina", "AR"));
        countries.add(new Country("Bolivia", "BO"));
        countries.add(new Country("Chile", "CL"));
        countries.add(new Country("Colombia", "CO"));
        countries.add(new Country("Ecuador", "EC"));
        countries.add(new Country("Mexico", "MX"));
        countries.add(new Country("Perú", "PE"));
        countries.add(new Country("Uruguay", "UY"));
        countries.add(new Country("Venezuela", "VE"));
        return countries;
    }
}
