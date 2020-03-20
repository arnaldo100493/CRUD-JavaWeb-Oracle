/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.interfaces;

import com.javaweb.modelo.Persona;
import java.util.List;

/**
 *
 * @author abarrime
 */
public interface PersonaDao {

    public List<Persona> listar();

    public Persona listarPorIdPersona(int idPersona);

    public int agregar(Persona persona);

    public int editar(Persona persona);

    public Persona eliminar(int idPersona);

}
