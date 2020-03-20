/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.impl;

import com.javaweb.interfaces.PersonaDao;
import com.javaweb.jdbc.Conexion;
import com.javaweb.modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abarrime
 */
public class PersonaDaoImpl implements PersonaDao {

    public PersonaDaoImpl() {

    }

    @Override
    public List<Persona> listar() {
        List<Persona> personas = new ArrayList<>();
        String sql = "select * from persona";
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                String correo = resultSet.getString(4);
                String telefono = resultSet.getString(5);
                Persona persona = new Persona(id, nombre, apellido, correo, telefono);
                personas.add(persona);
            }
        } catch (SQLException ex) {

        }
        return personas;
    }

    @Override
    public Persona listarPorIdPersona(int idPersona) {
        Persona persona = null;
        String sql = "select * from persona where id_persona = " + idPersona;
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                String correo = resultSet.getString(4);
                String telefono = resultSet.getString(5);
                persona = new Persona(id, nombre, apellido, correo, telefono);
            }

        } catch (SQLException ex) {

        }

        return persona;
    }

    @Override
    public int agregar(Persona persona) {
        String sql = "insert into persona(id_persona, nombre, apellido, correo, telefono) values(?, ?, ?, ?, ?)";
        int filasAfectadas = 0;
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, persona.getIdPersona());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellido());
            statement.setString(4, persona.getCorreo());
            statement.setString(5, persona.getTelefono());
            filasAfectadas = statement.executeUpdate();

        } catch (SQLException ex) {

        }
        return filasAfectadas;
    }

    @Override
    public int editar(Persona persona) {
        String sql = "update persona set nombre = ?, apellido = ?, correo = ?, telefono = ? where id_persona= " + persona.getIdPersona();
        int filasAfectadas = 0;
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setString(3, persona.getCorreo());
            statement.setString(4, persona.getTelefono());
            filasAfectadas = statement.executeUpdate();

            if (filasAfectadas == 0) {
                filasAfectadas = 1;
            } else {
                filasAfectadas = 0;
            }

        } catch (SQLException ex) {

        }

        return filasAfectadas;
    }

    @Override
    public Persona eliminar(int idPersona) {
        Persona persona = new Persona();
        String sql = "delete from persona where id_persona = " + idPersona;
        int filasAfectadas = 0;
        Connection conexion = Conexion.conectar();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            filasAfectadas = statement.executeUpdate();

            if (filasAfectadas == 0) {
                filasAfectadas = 1;
            } else {
                filasAfectadas = 0;
            }

        } catch (SQLException ex) {

        }
        return persona;
    }

}
