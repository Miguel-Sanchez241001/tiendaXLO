/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BEAN.ProductoBEAN;
import DAO.ProductoDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Rodrigo
 */
@MultipartConfig
@WebServlet(name = "ProductoServlet",urlPatterns = "/producto")
public class ProductoServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
       // String opcad = request.getParameter("op");
        
        int op = Integer.parseInt(request.getParameter("op"));
        ProductoBEAN objBean = new ProductoBEAN();
        ProductoDAO objDAO = new ProductoDAO();
        switch (op) {

            case 1:
                int idprod = 2;
                int id = 1;
                String producto = request.getParameter("producto");
                String descripcion = request.getParameter("descripcion");
                String costo = request.getParameter("costo");
                String categoria = request.getParameter("categoria");
                // Part part= request.getPart(request.);
                double precio = Integer.parseInt(costo);
                //InputStream inputStream =part.getInputStream();
                objBean.setCodigoProducto(idprod);
                objBean.setCodigoUsuario(id);
                objBean.setCategoria(categoria);
                objBean.setCosto(precio);
                objBean.setDescripcion(descripcion);
                //objBean.setFoto(inputStream);
                objBean.setProducto(producto);

                objDAO.AgregarProducto(objBean);

                break;

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
