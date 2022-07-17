package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SAlumnos", urlPatterns = {"/SAlumnos"})
public class SAlumnos extends HttpServlet {
    
    private String mostrar;
    private String nuevo;
    private String editar;
    
    private String accion;
    private String acceso;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       nuevo = "/vistas/vueno.jsp";
       editar = "/vistas/editar.jsp";
       mostrar = "vistas/mostrar.jsp";
       acceso = "";
       
       accion = request.getParameter("accion");
       
       if(accion!=null && accion.equalsIgnoreCase("Nuevo"))
       {
           acceso=nuevo;
       }
       else if(accion!=null && accion.equalsIgnoreCase("editar"))
       {
           acceso = editar;
       }
       else
       {
           acceso=mostrar;
       }
       request.getRequestDispatcher(acceso).forward(request, response);
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
