/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.controlador.web.categoria;

import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kimi
 */
@WebServlet(name = "ActualizarCategoria", urlPatterns = {"/ActualizarCategoria"})
public class ActualizarCategoria extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ActualizarCategoria</title>");
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" \n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>");
            out.println("</head>");
            out.println("<body>");

            CategoriaDAO dao = new CategoriaDAO();
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("id")));

            try {
                dto = dao.read(dto);
            } catch (SQLException ex) {
                Logger.getLogger(ActualizarCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (dto != null) {
                out.println("        <h1>Actualizacion de Categoría</h1>\n"
                        + "        <div  class=\"text-left\">\n"
                        + "            <br>\n"
                        + "            <br>\n"
                        + "            <form name=\"frmUpdate\" method=\"post\" action=\"updateCategoria\">\n"
                        + "                ID:<br>\n"
                        + "                <select name=\"idxtx\" class=\"form-control form-control-lg\">\n"
                        + "                    <option>" + dto.getEntidad().getIdCategoria() + "</option>\n"
                        + "                </select>\n"
                        + "                <br>\n"
                        + "                Nuevo Nombre Categoría:<br>\n"
                        + "                <input class=\"form-control\" type=\"text\" name=\"txtNombreu\" placeholder=\"Ingresa el nuevo nombre\" required/>\n"
                        + "                <br>\n"
                        + "                Nueva Descripción:<br>\n"
                        + "                <input class=\"form-control\" type=\"text\" name=\"txtDescripcionu\" placeholder=\"Ingresa la nueva descripción\" required/>\n"
                        + "                <div class=\"text-center\">\n"
                        + "                    <input class=\"btn btn-success\" type=\"submit\" value=\"Enviar\" name=\"btnEnviar\"/>\n"
                        + "                    <br> \n"
                        + "                    <br> \n"
                        + "                    <a  class=\"btn btn-danger\" href=\"MostrarDatosCategoria\">Listado Categorías</a>\n"
                        + "                </div>\n"
                        + "            </form>\n"
                        + "        </div>");
                //dto.getEntidad().getIdcategorria();
            }

            out.println("</body>");
            out.println("</html>");
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
