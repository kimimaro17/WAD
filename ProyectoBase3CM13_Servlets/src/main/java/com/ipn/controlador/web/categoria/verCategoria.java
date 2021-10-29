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
@WebServlet(name = "VerCategoria", urlPatterns = {"/VerCategoria"})
public class verCategoria extends HttpServlet {

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
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" \n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>");
            out.println("<title>Lista de categorias</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");

            out.println("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n"
                    + "                    <div class=\"container-fluid\">\n"
                    + "                        <a class=\"navbar-brand\" href=\"#\">Gestión de Productos</a>\n"
                    + "                        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                    + "                            <span class=\"navbar-toggler-icon\"></span>\n"
                    + "                        </button>\n"
                    + "                        <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n"
                    + "                            <ul class=\"navbar-nav\">\n"
                    + "                                <li class=\"nav-item\">\n"
                    + "                                    <a class=\"nav-link\" href=\"index.html\">Inicio</a>\n"
                    + "                                </li>\n"
                    + "                                <li class=\"nav-item\">\n"
                    + "                                    <a class=\"nav-link\" href=\"TablasDeMultiplicar\">Tablas de Multiplicar</a>\n"
                    + "                                </li>\n"
                    + "                                <li class=\"nav-item\">\n"
                    + "                                    <a class=\"nav-link active\" aria-current=\"page\" href=\"MostrarDatosCategoria\">Listado de Categorías</a>\n"
                    + "                                </li>\n"
                    + "                                <li class=\"nav-item\">\n"
                    + "                                    <a class=\"nav-link\" href=\"ProductoController?accion=listaDeProductos\">Listado de Productos</a>\n"
                    + "                                </li>\n"
                    + "                            </ul>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </nav>");
            out.println("<h2 class='text-center'>Información Categoría</h1>");
            CategoriaDAO dao = new CategoriaDAO();
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("id")));
            try {
                dto = dao.read(dto);
            } catch (SQLException ex) {
                Logger.getLogger(verCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (dto != null) {
                out.println("<div class='container'>");
                out.println("<table class=\"table table-bordered\">");
                out.print("<tr>");
                out.println("<th>Clave</th>");
                out.println("<th>Nombre</th>");
                out.println("<th>Descripción</th>");
                out.print("</tr>");
                out.print("<tr>");
                out.println("<th>" + dto.getEntidad().getIdCategoria() + "</th>");
                out.println("<th>" + dto.getEntidad().getNombreCategoria() + "</th>");
                out.println("<th>" + dto.getEntidad().getDescripcionCategoria() + "</th>");
                out.print("</tr>");
                out.println("</table>");
                out.println("<a href='MostrarDatosCategoria' class='btn btn-primary'>Listado de Categorías</a>");
                out.println("</div>");
            } else {
                out.println("<div class='container'>");
                out.println("<p>Vacio</p>");
                out.println("<a href='MostrarDatosCategoria' class='btn btn-primary'>Listado de Categorías</a>");
                out.println("</div>");
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
