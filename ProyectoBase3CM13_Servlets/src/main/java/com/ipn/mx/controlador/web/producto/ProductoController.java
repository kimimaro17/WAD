/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador.web.producto;

import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dao.ProductoDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.dto.ProductoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kimi
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

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

        String accion = request.getParameter("accion");
        if (accion.equals("listaDeProductos")) {
            listaDeProductos(request, response);
        } else {
            if (accion.equals("nuevo")) {
                nuevoProducto(request, response);
            } else {
                if (accion.equals("eliminar")) {
                    eliminarProducto(request, response);
                } else {
                    if (accion.equals("actualizar")) {
                        actualizarProducto(request, response);
                    } else {
                        if (accion.equals("ver")) {
                            verProducto(request, response);
                        } else {
                            if (accion.equals("guardar")) {
                                almacenarProducto(request, response);
                            } else {
                                if (accion.equals("update")) {
                                    updateProducto(request, response);
                                }
                            }
                        }
                    }
                }
            }
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

    private void listaDeProductos(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            out.println("<title>Ver Categoria</title>");
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
                    + "                                    <a class=\"nav-link\" href=\"MostrarDatosCategoria\">Listado de Categorías</a>\n"
                    + "                                </li>\n"
                    + "                                <li class=\"nav-item\">\n"
                    + "                                    <a class=\"nav-link active\" aria-current=\"page\" href=\"ProductoController?accion=listaDeProductos\">Listado de Productos</a>\n"
                    + "                                </li>\n"
                    + "                            </ul>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </nav>");
            out.println("<div>");
            out.println("<a href='ProductoController?accion=nuevo' class='btn btn-primary'>Registrar Producto</a>");
            out.println("</div>");
            out.println("<table class ='table table-striped'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<td>Clave del producto</td>");
            out.println("<td>Nombre del producto</td>");
            out.println("<td>Descripcion del producto</td>");
            out.println("<td>Precio del producto</td>");
            out.println("<td>Existencia del producto</td>");
            out.println("<td>Stock</td>");
            out.println("<td>Categoria</td>");
            out.println("<td>Eliminar</td>");
            out.println("<td>Actualizar</td>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            ProductoDAO dao = new ProductoDAO();
            List lista;
            try {
                lista = dao.readAll();
            } catch (SQLException ex) {
                lista = new ArrayList();
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < lista.size(); i++) {
                ProductoDTO dto = (ProductoDTO) lista.get(i);
                out.println("</tr>");
                out.println("<td><a href='ProductoController?accion=ver&id=" + dto.getEntidad().getIdProducto() + "' class='btn btn-warning'>" + dto.getEntidad().getIdProducto() + "</a></td>");
                out.println("<td>" + dto.getEntidad().getNombreProducto() + "</td>");
                out.println("<td>" + dto.getEntidad().getDescripcionProducto() + "</td>");
                out.println("<td>" + dto.getEntidad().getPrecio() + "</td>");
                out.println("<td>" + dto.getEntidad().getExistencia() + "</td>");
                out.println("<td>" + dto.getEntidad().getStockMinimo() + "</td>");
                out.println("<td>" + dto.getEntidad().getClaveCategoria() + "</td>");
                out.println("<td><a href='ProductoController?accion=eliminar&id=" + dto.getEntidad().getIdProducto() + "' class='btn btn-danger'>Eliminar</a></td>");
                out.println("<td><a href='ProductoController?accion=actualizar&id=" + dto.getEntidad().getIdProducto() + "' class='btn btn-success'>Actualizar</a></td>");
                out.println("</tr>");

            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void nuevoProducto(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("productoForm.html");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();

        dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));
        String msg = "";
        response.setContentType("text/html;charset=UTF-8");
        try {
            dao.delete(dto);
            msg = "Registro eliminado";
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>\n"
                    + "        <title>Agregar categoria</title>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" >\n"
                    + "        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n"
                    + "        <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" integrity=\"sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp\" crossorigin=\"anonymous\"></script>\n"
                    + "        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" integrity=\"sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/\" crossorigin=\"anonymous\"></script>\n"
                    + "    </head>");
            out.println("<body>");
            out.println("<div align='center'>");
            out.println("<b>" + msg + "</b><br>");
            out.println("<br />");
            out.println("<a text-align=\"center\" href='ProductoController?accion=listaDeProductos' class='btn btn-danger'>Lista de productos</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();

        CategoriaDAO categoriaDao = new CategoriaDAO();//para obtener los nombres de las claves de categoria
        List listaCategoria = null;

        dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));

        try {
            dto = dao.read(dto);
            listaCategoria = categoriaDao.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");

            out.println("<head>");
            out.println("<title>Actualizar Producto</title>");
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" \n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>");
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
                    + "                                    <a class=\"nav-link\" href=\"MostrarDatosCategoria\">Listado de Categorías</a>\n"
                    + "                                </li>\n"
                    + "                                <li class=\"nav-item\">\n"
                    + "                                    <a class=\"nav-link active\" aria-current=\"page\" href=\"ProductoController?accion=listaDeProductos\">Listado de Productos</a>\n"
                    + "                                </li>\n"
                    + "                            </ul>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </nav>");
            out.println("       <div class=\"container\">\n"
                    + "            <br>\n"
                    + "            <h1 align=\"center\">Acuatizar Producto</h1>\n"
                    + "            <br>\n"
                    + "        <form method=\"POST\" action=\"ProductoController?accion=update\">\n"
                    + "                <div class=\"mb-3\">\n"
                    + "                    <label for=\"idxtx\" class=\"form-label\">Id del producto</label>\n"
                    + "                <select name=\"idxtx\" class=\"form-control form-control-lg\">\n"
                    + "                    <option>" + dto.getEntidad().getIdProducto() + "</option>\n"
                    + "                </select>\n"
                    + "                </div>\n"
                    + "                <div class=\"mb-3\">\n"
                    + "                    <label for=\"txtNombreProducto\" class=\"form-label\">Nombre del producto</label>\n"
                    + "                    <input type=\"text\" id=\"txtNombreProducto\" name=\"txtNombreProducto\" placeholder=\"Nombre del producto\"\n"
                    + "                           class=\"form-control\" required=\"required\" value='" + dto.getEntidad().getNombreProducto() + "' />\n"
                    + "                </div>\n"
                    + "                <div class=\"mb-3\">\n"
                    + "                    <label for=\"txtDescripcionProducto\" class=\"form-label\">Descripcion del producto</label>\n"
                    + "                    <input type=\"text\" id=\"txtDescripcionProducto\" name=\"txtDescripcionProducto\" placeholder=\"Descripcion del producto\"\n"
                    + "                           class=\"form-control\" required=\"required\" value='" + dto.getEntidad().getDescripcionProducto() + "' />\n"
                    + "                </div>\n"
                    + "                <div class=\"mb-3\">\n"
                    + "                    <label for=\"txtPrecio\" class=\"form-label\">Precio del producto</label>\n"
                    + "                    <input type=\"text\" id=\"txtPrecio\" name=\"txtPrecio\" placeholder=\"$0.00\"\n"
                    + "                           class=\"form-control\" required=\"required\" value='" + dto.getEntidad().getPrecio() + "' />\n"
                    + "                </div>\n"
                    + "                <div class=\"mb-3\">\n"
                    + "                    <label for=\"txtExistencia\" class=\"form-label\">Existencia del producto</label>\n"
                    + "                    <input type=\"number\" id=\"txtExistencia\" step=\"1\" min=\"1\" max=\"100\" name=\"txtExistencia\" placeholder=\"Existencia\"\n"
                    + "                           class=\"form-control\" required=\"required\" value='" + dto.getEntidad().getExistencia() + "' />\n"
                    + "                </div>\n"
                    + "                <div class=\"mb-3\">\n"
                    + "                    <label for=\"txtStockMinimo\" class=\"form-label\">Stock del producto</label>\n"
                    + "                    <input type=\"number\" id=\"txtStockMinimo\" step=\"1\" min=\"10\" max=\"100\" name=\"txtStockMinimo\" placeholder=\"Stock del producto\"\n"
                    + "                           class=\"form-control\" required=\"required\" value='" + dto.getEntidad().getStockMinimo() + "' />\n"
                    + "                </div>\n"
                    + "                \n"
                    + "                <div class=\"mb-3\">\n"
                    + "                    <label for=\"idxtxclave\" class=\"form-label\">Clave de la categoria</label>\n"
                    + "<select name=\"idxtxclave\" id=\"idxtxclave\" class=\"form-control form-control-lg\">");

            for (int i = 0; i < listaCategoria.size(); i++) {
                CategoriaDTO dtoCategoria = (CategoriaDTO) listaCategoria.get(i);
                if (dtoCategoria.getEntidad().getIdCategoria() == dto.getEntidad().getClaveCategoria()) {
                    out.println("<option value=\"" + dtoCategoria.getEntidad().getIdCategoria() + "\" selected>" + dtoCategoria.getEntidad().getNombreCategoria() + "</option>");
                } else {
                    out.println("<option value=\"" + dtoCategoria.getEntidad().getIdCategoria() + "\">" + dtoCategoria.getEntidad().getNombreCategoria() + "</option>");
                }
            }
            out.println("</select></div>\n"
                    + "                <button type=\"submit\" class=\"btn-dark btn-lg\" >Mandar actualizaciones</button>\n"
                    + "            </form>\n"
                    + "        </div>");
            out.println("</body>");

            out.println("</html>");
        }
    }

    private void verProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            out.println("<title>Ver Categoria</title>");
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
                    + "                                    <a class=\"nav-link\" href=\"MostrarDatosCategoria\">Listado de Categorías</a>\n"
                    + "                                </li>\n"
                    + "                                <li class=\"nav-item\">\n"
                    + "                                    <a class=\"nav-link active\" aria-current=\"page\" href=\"ProductoController?accion=listaDeProductos\">Listado de Productos</a>\n"
                    + "                                </li>\n"
                    + "                            </ul>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </nav>");

            ProductoDAO dao = new ProductoDAO();
            ProductoDTO dto = new ProductoDTO();
            dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));

            try {
                dto = dao.read(dto);
            } catch (SQLException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (dto != null) {
                out.println("<table class ='table table-striped'>");
                out.println("<tr><th>Clave del producto <td>" + dto.getEntidad().getIdProducto() + "</td></th></tr>");
                out.println("<tr><th>Nombre del producto <td>" + dto.getEntidad().getNombreProducto() + "</td></th></tr>");
                out.println("<tr><th>Descripcion del producto <td>" + dto.getEntidad().getDescripcionProducto() + "</td></th></tr>");
                out.println("<tr><th>Precio del producto <td>" + dto.getEntidad().getPrecio() + "</td></th></tr>");
                out.println("<tr><th>Existencia del producto <td>" + dto.getEntidad().getExistencia() + "</td></th></tr>");
                out.println("<tr><th>Stock <td>" + dto.getEntidad().getStockMinimo() + "</td></th></tr>");
                out.println("<tr><th>Categoria <td>" + dto.getEntidad().getClaveCategoria() + "</td></th></tr>");
                out.println("</table>");
                out.println("<a href='ProductoController?accion=listaDeProductos' class='btn btn-success'>Listado de Productos</a>");
                out.println("</div>");
            } else {
                out.println("<div class='text-center'>");
                out.println("<p>Vacio</p>");
                out.println("<a href='ProductoController?accion=listaDeProductos' class='btn btn-primary'>Listado de Productos</a>");
                out.println("</div>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void almacenarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();

        dto.getEntidad().setNombreProducto(request.getParameter("txtNombreProducto"));
        dto.getEntidad().setDescripcionProducto(request.getParameter("txtDescripcionProducto"));
        dto.getEntidad().setExistencia(Integer.parseInt(request.getParameter("txtExistencia")));
        dto.getEntidad().setPrecio(new BigDecimal(request.getParameter("txtPrecio")));
        dto.getEntidad().setStockMinimo(Integer.parseInt(request.getParameter("txtStockMinimo")));
        dto.getEntidad().setClaveCategoria(Integer.parseInt(request.getParameter("txtClaveCategoria")));

        String msg = "";
        try {
            dao.create(dto);
            msg = "Registro almacenado";
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>\n"
                    + "        <title>Agregar categoria</title>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" >\n"
                    + "        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\n"
                    + "        <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" integrity=\"sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp\" crossorigin=\"anonymous\"></script>\n"
                    + "        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" integrity=\"sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/\" crossorigin=\"anonymous\"></script>\n"
                    + "    </head>");
            out.println("<body>");
            out.println("<div align='center'>");
            out.println("<b>" + msg + "</b><br>");
            out.println("<br />");
            out.println("<a text-align=\"center\" href='ProductoController?accion=listaDeProductos' class='btn btn-success'>Lista de productos</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void updateProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update</title>");
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" \n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class='text-center'>Estatus de la Actualización</h1>");

            ProductoDAO dao = new ProductoDAO();
            ProductoDTO dto = new ProductoDTO();
            System.out.println(request.getParameter("txtNombreProducto")+"\n "+
                    request.getParameter("txtDescripcionProducto")+"\n "+
                    request.getParameter("txtExistencia")+"\n "+
                    request.getParameter("txtPrecio")+"\n "+
                    request.getParameter("txtStockMinimo")+"\n "+
                    request.getParameter("idxtxclave"));
            
            dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("idxtx")));
            dto.getEntidad().setNombreProducto(request.getParameter("txtNombreProducto"));
            dto.getEntidad().setDescripcionProducto(request.getParameter("txtDescripcionProducto"));
            dto.getEntidad().setExistencia(Integer.parseInt(request.getParameter("txtExistencia")));
            dto.getEntidad().setPrecio(new BigDecimal(request.getParameter("txtPrecio")));
            dto.getEntidad().setStockMinimo(Integer.parseInt(request.getParameter("txtStockMinimo")));
            dto.getEntidad().setClaveCategoria(Integer.parseInt(request.getParameter("idxtxclave")));
            
            
            String msg = "";
            String ms = "Estado:  ";
           
            try {
                dao.Update(dto);
                msg = "Actualización concluida, revisar Listado de categorias para comprobar";
            } catch (SQLException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            out.println("<div class='text-center'>");
            out.println("<b>" + ms + msg + "</b>");
            out.println("<br>");
            out.println("<a href='ProductoController?accion=listaDeProductos' class='btn btn-primary'>Listado de productos</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
