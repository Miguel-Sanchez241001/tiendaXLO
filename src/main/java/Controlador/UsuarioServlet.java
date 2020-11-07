/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BEAN.UserBEAN;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "UsuarioServlet",urlPatterns = "/usuario")
public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            UserBEAN objbean = new UserBEAN();
            UsuarioDAO objdao = new UsuarioDAO();
            JSONObject json = new JSONObject();

            String opcad = request.getParameter("op");
            int op = Integer.parseInt(opcad);
            switch (op) {
                case 1: {
                    String nombre = request.getParameter("nombre");
                    String apellidos = request.getParameter("apellidos");
                    String telefono = request.getParameter("telefono");
                    String email = request.getParameter("email");
                    String usuario = request.getParameter("usuario");
                    String clave = request.getParameter("clave");
                    json.put("nombre", nombre);
                    json.put("apellidos", apellidos);
                    json.put("telefono", telefono);
                    json.put("email", email);
                    json.put("usuario", usuario);
                    json.put("clave", clave);
                    out.print(json);
                    int tel = Integer.parseInt(telefono);

                    objbean.setUsuario(usuario);
                    objbean.setClave(clave);
                    objbean.setNombre(nombre);
                    objbean.setApellido(apellidos);
                    objbean.setEmail(email);
                    objbean.setTelefono(tel);
                    objdao.AgregarUsuario(objbean);

                    objdao.AgregarLogin(objbean);
                    break;
                }
                case 2: {
                    String usuario = request.getParameter("usuario");
                    String clave = request.getParameter("clave");

                    objbean.setUsuario(usuario);
                    objbean.setClave(clave);

                    int valido = objdao.ValidarLogin(objbean);

                    if (valido == 0) {
                        response.getWriter().print("Las credenciales son incorrectas");
                    } else {
                        HttpSession userSession = request.getSession(true);
                        userSession.setAttribute("nombre", objbean.getNombre());
                        userSession.setAttribute("apellidos", objbean.getApellido());
                        userSession.setAttribute("telefono", objbean.getTelefono());
                        userSession.setAttribute("email", objbean.getEmail());

                        json.put("nombre", objbean.getNombre());
                        json.put("apellidos", objbean.getApellido());
                        json.put("mensaje", "Sesion iniciada");
                        response.getWriter().print(json);

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

}
