/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unipiloto.edu.student.servlet;

import co.edu.unipiloto.student.Estudiante;
import co.edu.unipiloto.student.session.EstudianteFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Camilo Gomez
 */
public class StudentServlet extends HttpServlet {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;

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
        String id = request.getParameter("studentId");
        Integer estudianteId = new Integer(0);
        if (id != null && id.equals("")) {
            estudianteId = Integer.parseInt(id);
        }
        ;
        String name = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String yearLevel = request.getParameter("yearLevel");
        Integer semestreEstudiante = new Integer(0);
        if (yearLevel != null && yearLevel.equals("")) {
            semestreEstudiante = Integer.parseInt(yearLevel);
        }
        Estudiante est = new Estudiante();
        String action = request.getParameter("action");
        if (action.equals("Add")) {
            est.setEstudianteid(estudianteId);
            est.setNombre(name);
            est.setApellido(lastName);
            est.setSemestre(semestreEstudiante);
            estudianteFacade.create(est);
        }
        request.setAttribute("student", est);
        request.setAttribute("allStudents",estudianteFacade.findAll());
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
        
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
