/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.controlador;

import com.javaweb.impl.PersonaDaoImpl;
import com.javaweb.interfaces.PersonaDao;
import com.javaweb.modelo.Persona;
import java.util.List;

/**
 *
 * @author abarrime
 */
public class PersonaControlador {

    private final PersonaDao personaDao;

    public PersonaControlador() {
        this.personaDao = new PersonaDaoImpl();
    }

    public List<Persona> listar() {
        return this.personaDao.listar();
    }

    public Persona listarPorIdPersona(int idPersona) {
        return this.personaDao.listarPorIdPersona(idPersona);
    }

    public int agregar(Persona persona) {
        return this.personaDao.agregar(persona);
    }

    public int editar(Persona persona) {
        return this.personaDao.editar(persona);
    }

    public Persona eliminar(int idPersona) {
        return this.personaDao.eliminar(idPersona);
    }

}
