/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.clsProducto;
import modelo.gestionBDD;
import modelo.manejoBDD;

/**
 *
 * @author H4HG
 */
@WebServlet(name = "entradaProducto", urlPatterns = {"/entradaProducto"})
public class entradaProducto extends HttpServlet {

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
        
        String vRegresar = "./consultaProductos.jsp";
        String vContinuar = "./index.html";
        
        int vCodigo = Integer.parseInt(request.getParameter("codigo"));
        int vCantidad = Integer.parseInt(request.getParameter("cantidad"));
        int vCantidadOriginal = 0;
        int vCantidadFinal = 0;
        
        ArrayList<clsProducto> aProducto = manejoBDD.productosRegistrados();
        Iterator<clsProducto> iter = aProducto.iterator();
        clsProducto per = null;
                
        while(iter.hasNext())
        {
            per = iter.next();  
            if(vCodigo == per.getvCodigo())  
            {
                vCantidadOriginal = per.getvCantidad();
            }
        }
        
        vCantidadFinal = vCantidadOriginal + vCantidad;
        
        gestionBDD update = new gestionBDD();
        int resp = update.actualizacionProductos(vCodigo, vCantidadFinal);

        if(resp == 1)
        {
            try (PrintWriter out = response.getWriter()) 
                {                
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Retiro exitoso</title>");
                    out.println("<link rel=\"stylesheet\" href=\"./css/styleServlet.css\">");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Actualizacion exitosa</h1>");
                    out.println("<p>Se han añadido: " + vCantidad + " unidades del producto " + vCodigo +"</p>");
                    out.println("<p>La cantidad disponible es de: " + vCantidadFinal + " unidades del producto " + vCodigo +"</p>");
                    out.println("<a href=" + vRegresar + "> Haga clic para volver a registrar </a><br/>");
                    out.println("<a href=" + vContinuar + "> Haga clic para salir </a> <br/>");        
                    out.println("</body>");
                    out.println("</html>");
                }
        }else
        {
            try (PrintWriter out = response.getWriter()) 
            {        
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Entrada fallida!!</title>");
                out.println("<link rel=\"stylesheet\" href=\"./css/styleServlet.css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Codigo invalido</h1>");
                out.println("<p>El codigo: " + vCodigo + " no existe, favor verifique</p>");
                out.println("<a href=" + vRegresar + "> Haga clic para reintentar </a><br/>");
                out.println("<a href=" + vContinuar + "> Haga clic para salir </a> <br/>");        
                out.println("</body>");
                out.println("</html>");
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
