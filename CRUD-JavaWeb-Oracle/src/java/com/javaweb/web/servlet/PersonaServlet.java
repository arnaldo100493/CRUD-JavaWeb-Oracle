/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.web.servlet;

import com.javaweb.controlador.PersonaControlador;
import com.javaweb.modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abarrime
 */
//@WebServlet(name = "Persona", urlPatterns = {"/persona", "/personaServlet"})
public class PersonaServlet extends HttpServlet {

    public PersonaServlet() {

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PersonaControlador personaControlador = new PersonaControlador();
        Persona persona = new Persona();

        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":
                List<Persona> personas = personaControlador.listar();
                request.setAttribute("personas", personas);
                RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/listar.jsp");
                dispatcher.forward(request, response);
                break;

            case "Agregar":
                dispatcher = request.getRequestDispatcher("vistas/agregar.jsp");
                dispatcher.forward(request, response);
                break;

            case "Guardar":
                int idPersona = Integer.parseInt(request.getParameter("idPersona"));
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String correo = request.getParameter("correo");
                String telefono = request.getParameter("telefono");
                persona.setIdPersona(idPersona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setCorreo(correo);
                persona.setTelefono(telefono);
                personaControlador.agregar(persona);
                dispatcher = request.getRequestDispatcher("./persona?accion=Listar");
                dispatcher.forward(request, response);
                break;

            case "Editar":
                int id = Integer.parseInt(request.getParameter("id"));
                Persona p = personaControlador.listarPorIdPersona(id);
                request.setAttribute("persona", p);
                dispatcher = request.getRequestDispatcher("vistas/editar.jsp");
                dispatcher.forward(request, response);
                break;

            case "Actualizar":
                int idPersonaActualizar = Integer.parseInt(request.getParameter("idPersona"));
                String nombreActualizar = request.getParameter("nombre");
                String apellidoActualizar = request.getParameter("apellido");
                String correoActualizar = request.getParameter("correo");
                String telefonoActualizar = request.getParameter("telefono");
                persona.setIdPersona(idPersonaActualizar);
                persona.setNombre(nombreActualizar);
                persona.setApellido(apellidoActualizar);
                persona.setCorreo(correoActualizar);
                persona.setTelefono(telefonoActualizar);
                personaControlador.editar(persona);
                dispatcher = request.getRequestDispatcher("./persona?accion=Listar");
                dispatcher.forward(request, response);
                break;
                
            case "Eliminar":
             int idPersonaEliminar = Integer.parseInt(request.getParameter("id"));
             personaControlador.eliminar(idPersonaEliminar);
             dispatcher = request.getRequestDispatcher("./persona?accion=Listar");
             dispatcher.forward(request, response);
            break;

            default:
                throw new AssertionError();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
