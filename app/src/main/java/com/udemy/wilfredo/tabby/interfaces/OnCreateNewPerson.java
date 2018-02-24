package com.udemy.wilfredo.tabby.interfaces;

import com.udemy.wilfredo.tabby.model.Person;

/**
 * Interfaz necesaria para la comunicación entre fragments y Activities
 * En este caso particular para poder crear una persona dentro de la aplicación
 * Created by wilfredo on 24-02-18.
 */

public interface OnCreateNewPerson {
    /**
     * Método que debe ser implementado para crear una persona en la aplicación
     * @param person representa a una persona a crear en la aplicación
     */
    void createNewPerson(Person person);
}
