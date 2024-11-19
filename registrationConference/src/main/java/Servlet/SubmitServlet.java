/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class SubmitServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        String sql = "INSERT INTO person (name, phone, email) VALUES (?, ?, ?)";
        try {
            Connection conn = (Connection) getServletContext().getAttribute("conn");

            String GetDataBase = "SELECT *  FROM  persons.person";
            Statement stmt = conn.createStatement();
            ResultSet rsGetDataBase = stmt.executeQuery(GetDataBase);

            // Iterate through the result set and display data in table rows
            while (rsGetDataBase.next()) {
                String emailInData = rsGetDataBase.getString("email");
                if (email.equalsIgnoreCase(emailInData)) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Regestration</title>" + "");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<a href='Registration.html'>This email exist please enter anoter email</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, email);
            pstmt.executeUpdate();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Regestration</title>" + "");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Your data added to conference attendance menu" + "</h1>");
            out.println("<a href='showDataBase.jsp'>Click her if you wand see Attendance Menu</a>");
            out.println("</body>");
            out.println("</html>");
       
            rsGetDataBase.close();
            stmt.cancel();
           
        } catch (SQLException ex) {
            Logger.getLogger(SubmitServlet.class.getName()).log(Level.SEVERE, null, ex);
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
